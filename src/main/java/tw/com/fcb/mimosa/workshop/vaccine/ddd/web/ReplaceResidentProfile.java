package tw.com.fcb.mimosa.workshop.vaccine.ddd.web;

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
