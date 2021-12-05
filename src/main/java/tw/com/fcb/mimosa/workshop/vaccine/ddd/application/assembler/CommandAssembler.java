package tw.com.fcb.mimosa.workshop.vaccine.ddd.application.assembler;

import tw.com.fcb.mimosa.workshop.vaccine.ddd.application.command.CancelVaccine;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.application.command.ChooseVaccine;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.application.command.MakeAppointment;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.domain.Appointment;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.domain.Cancel;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.domain.Choose;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.infra.repository.CancelEntity;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.infra.repository.ChooseEntity;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.infra.repository.ResidentEntity;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.rest.CancelVaccineRequest;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.rest.ChooseVaccineRequest;
import tw.com.fcb.mimosa.workshop.vaccine.ddd.rest.MakeAppointmentRequest;
import tw.com.fcb.mimosa.workshop.vaccine.sharedkernel.Vaccine;

public interface CommandAssembler {

	public MakeAppointment toCommand(MakeAppointmentRequest request);
	
	public ChooseVaccine toChooseVaccineCommand(ChooseVaccineRequest request);
	
	public CancelVaccine toCancelVaccineCommand(CancelVaccineRequest request);
	
	public Appointment toDomain(MakeAppointment request);
	
	public Choose toDomain(ChooseVaccineRequest request);
	
	public Cancel toDomain(CancelVaccineRequest request);
	
	Choose toChoose(Vaccine data);

	Cancel toCancel(Vaccine data);

}
