package tw.com.fcb.mimosa.workshop.vaccine.ddd.rest;

import java.util.List;

import tw.com.fcb.mimosa.workshop.vaccine.sharedkernel.Vaccine;

public class MakeAppointmentRequest {
	  String nhiNo;
	  String phoneNo;

	  List<Vaccine> chooses;
}
