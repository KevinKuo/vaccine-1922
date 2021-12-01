package tw.com.fcb.mimosa.workshop.vaccine.crud.service;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import lombok.RequiredArgsConstructor;
import tw.com.fcb.mimosa.workshop.vaccine.crud.repository.CrudChooseEntity;
import tw.com.fcb.mimosa.workshop.vaccine.crud.repository.CrudResidentRepository;
import tw.com.fcb.mimosa.workshop.vaccine.crud.web.CrudResidentMapper;
import tw.com.fcb.mimosa.workshop.vaccine.crud.web.ResidentDto;

@Service
@Transactional
@RequiredArgsConstructor
public class CrudResidentService {

  final CrudResidentRepository repository;
  final CrudResidentMapper mapper;

  public Long createResident(ResidentDto dto) {
    return repository.save(mapper.toEntity(dto)).getId();
  }

  public void updateResident(Long id, ResidentDto dto) {
    var db = repository.findById(id).orElseThrow();
    //更新手機
    if (StringUtils.hasText(dto.getPhoneNo())) {
      db.setPhoneNo(dto.getPhoneNo());
    }

    //刪除清單
    var drops = db.getCrudChooseEntity().stream().filter(dbChoose -> dto.getChooses().contains(dbChoose.getVaccine()))
        .collect(Collectors.toList());
    db.getCrudChooseEntity().removeAll(drops);

    //取消清單
    var cancels = drops.stream().map(CrudChooseEntity::getVaccine).map(mapper::toCancelEntity)
        .collect(Collectors.toList());
    db.getCrudCancelEntity().addAll(cancels);

    //加入清單
    var appends = dto.getChooses().stream().filter(dtoChoose -> {
      return db.getCrudChooseEntity().stream().map(CrudChooseEntity::getVaccine).noneMatch(dtoChoose::equals);
    }).map(mapper::toChooseEntity)
        .collect(Collectors.toList());
    db.getCrudChooseEntity().addAll(appends);
    repository.save(db);
  }
}
