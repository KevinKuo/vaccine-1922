package tw.com.fcb.mimosa.workshop.vaccine.crud.repository;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Table(name = "CRUD_RESIDENT")
@Entity
@Data
public class CrudResidentEntity {
  @Id
  @GeneratedValue
  Long id;

  String nhiNo;
  String phoneNo;

  @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL) //預設不會刪除外鍵的資料, orphan代表已無主鍵之資料
  @JoinColumn(name = "resident_id")
  List<CrudChooseEntity> crudChooseEntity;

  @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
  @JoinColumn(name = "resident_id")
  List<CrudCancelEntity> crudCancelEntity;
}
