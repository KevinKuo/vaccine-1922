package tw.com.fcb.mimosa.workshop.vaccine.ddd.domain;

import java.time.LocalDateTime;

import lombok.Data;
import tw.com.fcb.mimosa.workshop.vaccine.sharedkernel.Vaccine;

@Data
public class Choose {
	  long id;
	  LocalDateTime chooseTime;
	  Vaccine vaccine;
}
