package tw.com.fcb.mimosa.workshop.vaccine.ddd.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.com.fcb.mimosa.workshop.vaccine.crud.repository.CrudResidentEntity;

public interface AppointmentRepository extends JpaRepository<CrudResidentEntity, Long>{
	long save(Appointment domain);
}
