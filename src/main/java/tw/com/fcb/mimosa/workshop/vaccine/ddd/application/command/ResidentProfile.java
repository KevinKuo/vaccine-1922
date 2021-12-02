package tw.com.fcb.mimosa.workshop.vaccine.ddd.application.command;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tw.com.fcb.mimosa.workshop.vaccine.sharedkernel.Vaccine;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ResidentProfile {
  String nhiNo;
  String phoneNo;

  List<Vaccine> chooses;
}
