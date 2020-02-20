package gr.edu.uom.fleetmanager.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "taxi")
@Access(value = AccessType.FIELD)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Taxi extends Vehicle {

  @Column(name = "capability_seat")
  private Integer capabilitySeat;

  public Integer getCapabilitySeat() {
    return capabilitySeat;
  }

  public void setCapabilitySeat(Integer capabilitySeat) {
    this.capabilitySeat = capabilitySeat;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    Taxi taxi = (Taxi) o;
    return Objects.equals(capabilitySeat, taxi.capabilitySeat);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), capabilitySeat);
  }
}
