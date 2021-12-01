package tw.com.fcb.mimosa.workshop.vaccine.ddd.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.repository.ChooseEntity;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.repository.ResidentRepository;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.web.CancelVaccine;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.web.ChooseVaccine;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.web.ReplaceResidentProfile;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.web.ResidentMapper;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.web.ResidentProfile;

@Service
@Transactional
@RequiredArgsConstructor
public class ResidentService {

  final ResidentRepository repository;
  final ResidentMapper mapper;

  public List<ResidentProfile> getResidents() {
    return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
  }

  public long insertResidentProfile(ResidentProfile command) {
    return repository.save(mapper.toEntity(command)).getId();
  }

  public void insertVaccine(long id, ResidentProfile command) {
    var db = repository.findById(id).orElseThrow();
    var choose = command.getVaccines().stream().map(mapper::toChoose).collect(Collectors.toList());
    db.setChooseEntity(choose);
    repository.save(db);
  }

  public void replaceResidentProfile(long id, ReplaceResidentProfile command) {
    var db = repository.findById(id).orElseThrow();
    db.setPhoneNo(command.getPhoneNo());

    repository.save(db);
  }

  public void chooseVaccine(long id, ChooseVaccine command) {
    var db = repository.findById(id).orElseThrow();
    //var append = command.getVaccines().stream().map(mapper::toChoose).collect(Collectors.toList());
    var append = command.getVaccines().stream().filter(choose -> {
        return db.getChooseEntity().stream().map(ChooseEntity::getVaccine).noneMatch(command.getVaccines()::equals);
      }).map(mapper::toChoose)
          .collect(Collectors.toList());
    
    db.getChooseEntity().addAll(append);
    repository.save(db);
  }

  public void cancelVaccine(long id, CancelVaccine command) {
    var db = repository.findById(id).orElseThrow();
    var drop = db.getChooseEntity().stream()
        .filter(dbChoose -> command.getVaccines().contains(dbChoose.getVaccine())).collect(Collectors.toList());
    db.getChooseEntity().removeAll(drop);

    // stream 代表轉成collection物件
    // map 把資料的某個型態 轉成另一個型態
    // filter 用迴圈檢查每個物件是否符合你要的條件
    var cancel = command.getVaccines().stream().map(mapper::toCancel).collect(Collectors.toList());
    db.getCancelEntity().addAll(cancel);

    repository.save(db);
  }
}
