package tw.com.fcb.mimosa.workshop.vaccine.ddd.domain;

import tw.com.fcb.mimosa.workshop.vaccine.ddd.infra.repository.ResidentEntity;

public interface AppointmentRepository{
	long save(Appointment domain);
	
	public ResidentEntity findById(long id);
}
