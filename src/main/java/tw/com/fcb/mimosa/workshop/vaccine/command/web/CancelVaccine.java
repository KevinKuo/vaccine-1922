package tw.com.fcb.mimosa.workshop.vaccine.command.web;

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
public class CancelVaccine {

  List<Vaccine> cancels;
}
