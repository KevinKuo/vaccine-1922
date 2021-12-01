package tw.com.fcb.mimosa.workshop.vaccine.ddd.web;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import tw.com.fcb.mimosa.workshop.vaccine.sharedkernel.Vaccine;

@Table(name = "RESIDENT")
@Entity
@Data
public class MakeAppointment {
	  String nhiNo;
	  String phoneNo;
	  
	  List<Vaccine> vaccines;
}
