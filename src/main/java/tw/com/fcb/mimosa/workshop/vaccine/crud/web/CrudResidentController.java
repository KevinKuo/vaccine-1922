package tw.com.fcb.mimosa.workshop.vaccine.crud.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import tw.com.fcb.mimosa.workshop.vaccine.crud.service.CrudResidentService;

/**
 * CRUD 風格 API
 */
@RequiredArgsConstructor
@RequestMapping("/crud/residents")
@RestController
class CrudResidentController {

  final CrudResidentService service;

  @GetMapping
  void getResident() {
  }

  @PostMapping
  Long createResident(@RequestBody ResidentDto dto) {
    return service.createResident(dto);
  }

  @PutMapping("/{id}")
  void updateResident(@PathVariable("id") long id, @RequestBody ResidentDto dto) {
    service.updateResident(id, dto);
  }

}
