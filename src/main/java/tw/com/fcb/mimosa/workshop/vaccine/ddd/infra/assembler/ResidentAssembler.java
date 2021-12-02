package tw.com.fcb.mimosa.workshop.vaccine.ddd.infra.assembler;

import org.mapstruct.Mapper;

import tw.com.fcb.mimosa.workshop.vaccine.ddd.application.command.CancelVaccine;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.application.command.ChooseVaccine;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.domain.Appointment;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.domain.Cancel;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.domain.Choose;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.infra.repository.CancelEntity;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.infra.repository.ChooseEntity;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.infra.repository.ResidentEntity;

@Mapper
public interface ResidentAssembler {

	ResidentEntity toEntity(Appointment domain);
	
	ChooseEntity toChooseVaccineEntity(ChooseVaccine domain);

	CancelEntity toCancelVaccineEntity(CancelVaccine domain);

}
