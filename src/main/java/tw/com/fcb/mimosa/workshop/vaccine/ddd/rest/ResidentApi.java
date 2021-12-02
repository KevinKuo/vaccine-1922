package tw.com.fcb.mimosa.workshop.vaccine.ddd.rest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/residents")
public interface ResidentApi {

	  @PostMapping
	  long makeAppointment(@RequestBody MakeAppointmentRequest request);
	  //定義好自己的物件, 不要相依原本的MakeAppointment
	  
	  @PutMapping("/{id}/vaccines")
	  void chooseVaccine(@PathVariable("id") long id, @RequestBody ChooseVaccineRequest command);
	  
	  @DeleteMapping("/{id}/vaccines")
	  void chooseVaccine(@PathVariable("id") long id, @RequestBody CancelVaccineRequest command);
}
