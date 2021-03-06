package tw.com.fcb.mimosa.workshop.vaccine.ddd.infra.repository;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import tw.com.fcb.mimosa.workshop.vaccine.sharedkernel.Vaccine;

@Table(name = "CHOOSE")
@Entity
@Data
public class ChooseEntity {
  @Id
  @GeneratedValue
  Long id;
  LocalDateTime chooseTime;

  //預設enum式數字, 如果要用string排序要多加這個
  @Enumerated(EnumType.STRING)
  Vaccine vaccine;
}
