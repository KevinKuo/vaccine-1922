package tw.com.fcb.mimosa.workshop.vaccine.command.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ReplaceResidentProfile {

  String phoneNo;
}
