package tw.com.fcb.mimosa.workshop.vaccine.ddd.infra.repository;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.domain.Appointment;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.domain.AppointmentRepository;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.infra.assembler.ResidentAssembler;

@Repository
@RequiredArgsConstructor
public class AppointmentRepositoryImpl implements AppointmentRepository{

	final ResidentRepository jpaRepository;
	final ResidentAssembler assembler;
	
	@Override
	public long save(Appointment domain) {
		// TODO Auto-generated method stub
		return jpaRepository.save(assembler.toEntity(domain)).getId();
	}	
	
	@Override
	public Appointment findById(long id) {
		// TODO Auto-generated method stub
		var data = jpaRepository.findById(id).orElseThrow();
		return assembler.toResident(data);
	}
}
