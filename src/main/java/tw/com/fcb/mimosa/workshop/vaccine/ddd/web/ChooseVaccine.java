package tw.com.fcb.mimosa.workshop.vaccine.ddd.web;

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
public class ChooseVaccine {
  List<Vaccine> vaccines;
}
