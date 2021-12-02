package tw.com.fcb.mimosa.workshop.vaccine.command.web;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import tw.com.fcb.mimosa.workshop.vaccine.command.service.ResidentService;

/**
 * 命令風格 API
 */
@RequiredArgsConstructor
@RequestMapping("/residents")
@RestController
class ResidentController {

  final ResidentService service;

  @PostMapping
  long makeAppointment(@RequestBody MakeAppointment command) {
    return service.makeAppointment(command);
    //service.insertVaccine(id, command);
  }

  //課堂上做

  @PutMapping("/{id}")
  void replaceResidentProfile(@PathVariable("id") long id, @RequestBody ReplaceResidentProfile command) {
    service.replaceResidentProfile(id, command);
  }

  @PutMapping("/{id}/vaccines")
  void chooseVaccine(@PathVariable("id") long id, @RequestBody ChooseVaccine command) {
    service.chooseVaccine(id, command);
  }

  @DeleteMapping("/{id}/vaccines")
  void cancelVaccine(@PathVariable("id") long id, @RequestBody CancelVaccine command) {
    service.cancelVaccine(id, command);
  }

  //

  @GetMapping
  List<ResidentProfile> getResidents() {
    return service.getResidents();
  }
}
