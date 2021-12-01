package tw.com.fcb.mimosa.workshop.vaccine.crud.web;

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
public class ResidentDto {

  String nhiNo;
  String phoneNo;

  List<Vaccine> chooses;

}
