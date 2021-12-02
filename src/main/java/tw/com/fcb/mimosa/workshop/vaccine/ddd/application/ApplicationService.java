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
	  
	  public long chooseVaccine(ChooseVaccine command) {
		  
		  var domain = repository.findById(command.getId());
		    var appends = command.getChooses().stream().filter(choose -> {
		        return domain.getChooses().stream().map(Choose::getVaccine).noneMatch(choose::equals);
		      }).map(assembler::toChoose)
		          .collect(Collectors.toList());
		    
		    domain.getChooses().addAll(appends);
		    repository.save(domain);
		  	return repository.save(assembler.toDomain(command));
	  }
	  
	  public long cancelVaccine(CancelVaccine command) {
		  	return repository.save(assembler.toDomain(command));
	  }

}
