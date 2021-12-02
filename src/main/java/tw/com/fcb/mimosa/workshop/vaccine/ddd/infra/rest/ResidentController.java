package tw.com.fcb.mimosa.workshop.vaccine.ddd.infra.rest;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.application.ApplicationService;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.application.assembler.CommandAssembler;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.rest.CancelVaccineRequest;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.rest.ChooseVaccineRequest;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.rest.MakeAppointmentRequest;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.rest.ResidentApi;

@RestController
@RequiredArgsConstructor
class ResidentController implements ResidentApi {

	final ApplicationService service;
	final CommandAssembler assembler;
	
	@Override
	public long makeAppointment(MakeAppointmentRequest request) {
		// TODO Auto-generated method stub
		return service.makeAppointment(assembler.toCommand(request));
	}

	@Override
	public void chooseVaccine(long id, ChooseVaccineRequest request) {
		// TODO Auto-generated method stub
		var command = assembler.toChooseVaccineCommand(request);
		command.setId(id);
		service.chooseVaccine(command);
		
	}

	@Override
	public void chooseVaccine(long id, CancelVaccineRequest request) {
		// TODO Auto-generated method stub
		var command = assembler.toCancelVaccineCommand(request);
		command.setId(id);
		service.cancelVaccine(command);
	}
}
