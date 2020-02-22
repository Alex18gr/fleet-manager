package gr.edu.uom.fleetmanager.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "motorcycle")
@Access(value = AccessType.FIELD)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Motorcycle extends Vehicle {

  @Column(name="auto")
  protected String auto;

  public Motorcycle(){
    super.setType("Motorcycle");
  }

  public String getAuto() {
    return auto;
  }

  public void setAuto(String auto) {
    this.auto = auto;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    Motorcycle that = (Motorcycle) o;
    return Objects.equals(auto, that.auto);
  }

  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), auto);
  }
}
