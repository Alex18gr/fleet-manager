package gr.edu.uom.fleetmanager.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "taxi")
@Access(value = AccessType.FIELD)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Taxi extends Vehicle {

  @Column(name="weight")
  protected Double weight;

  public Taxi(){
    super.setType("Taxi");
  }

  public Double getWeight() {
    return weight;
  }

  public void setWeight(Double weight) {
    this.weight = weight;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    Taxi taxi = (Taxi) o;
    return Objects.equals(weight, taxi.weight);
  }

  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), weight);
  }
}
