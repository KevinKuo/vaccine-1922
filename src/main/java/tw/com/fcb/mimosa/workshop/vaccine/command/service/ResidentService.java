 package tw.com.fcb.mimosa.workshop.vaccine.command.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import tw.com.fcb.mimosa.workshop.vaccine.command.web.CancelVaccine;
import tw.com.fcb.mimosa.workshop.vaccine.command.web.ChooseVaccine;
import tw.com.fcb.mimosa.workshop.vaccine.command.web.MakeAppointment;
import tw.com.fcb.mimosa.workshop.vaccine.command.web.ReplaceResidentProfile;
import tw.com.fcb.mimosa.workshop.vaccine.command.web.ResidentMapper;
import tw.com.fcb.mimosa.workshop.vaccine.command.web.ResidentProfile;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.infra.repository.ChooseEntity;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.infra.repository.ResidentRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class ResidentService {

  final ResidentRepository repository;
  final ResidentMapper mapper;

  public List<ResidentProfile> getResidents() {
    return repository.findAll().stream().map(mapper::fromEntity).collect(Collectors.toList());
  }

  public long makeAppointment(MakeAppointment command) {
    return repository.save(mapper.toEntity(command)).getId();
  }

  public void insertVaccine(long id, MakeAppointment command) {
    var db = repository.findById(id).orElseThrow();
    var choose = command.getChooses().stream().map(mapper::toChoose).collect(Collectors.toList());

    db.getChooses().addAll(choose);
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
    
    var appends = command.getChooses().stream().filter(choose -> {
        return db.getChooses().stream().map(ChooseEntity::getVaccine).noneMatch(choose::equals);
      }).map(mapper::toChoose)
          .collect(Collectors.toList());
    
    db.getChooses().addAll(appends);
    repository.save(db);
  }

  public void cancelVaccine(long id, CancelVaccine command) {
    var db = repository.findById(id).orElseThrow();
    var drop = db.getChooses().stream()
        .filter(choose -> command.getCancels().contains(choose.getVaccine())).collect(Collectors.toList());
    db.getChooses().removeAll(drop);

    // stream 代表轉成collection物件
    // map 把資料的某個型態 轉成另一個型態
    // filter 用迴圈檢查每個物件是否符合你要的條件
    var cancel = command.getCancels().stream().map(mapper::toCancel).collect(Collectors.toList());
    db.getCancels().addAll(cancel);

    repository.save(db);
  }
}
