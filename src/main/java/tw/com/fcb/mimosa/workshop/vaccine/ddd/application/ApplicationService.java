package tw.com.fcb.mimosa.workshop.vaccine.ddd.application;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.application.assembler.CommandAssembler;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.application.command.CancelVaccine;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.application.command.ChooseVaccine;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.application.command.MakeAppointment;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.domain.AppointmentRepository;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.domain.Choose;

@Service
@RequiredArgsConstructor
public class ApplicationService {
	
	  final AppointmentRepository repository;
	  final CommandAssembler assembler;
	  
	  public long makeAppointment(MakeAppointment command) {
		  	return repository.save(assembler.toDomain(command));
	  }
	  
	  public void chooseVaccine(ChooseVaccine command) {
		  
		  //Appointment
		  var domain = repository.findById(command.getId());
		    var appends = command.getChooses().stream()
		    		.filter(choose -> {
		        return domain.getChooses().stream().map(Choose::getVaccine).noneMatch(choose::equals);
		      }).map(assembler::toChoose)
		          .collect(Collectors.toList());
		    domain.setChooses(appends);
		    repository.save(domain);
	  }
	  
	  public void cancelVaccine(CancelVaccine command) {
		    var domain = repository.findById(command.getId());
		    var drop = domain.getChooses().stream()
		        .filter(choose -> 
		        command.getCancels().contains(choose.getVaccine())).collect(Collectors.toList());
		    domain.getChooses().removeAll(drop);
		    
		    var cancel = command.getCancels().stream().map(assembler::toCancel).collect(Collectors.toList());
		    domain.getCancels().addAll(cancel);
		    
		    repository.save(domain);
	  }

}
