package gr.edu.uom.fleetmanager.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "minivan")
@Access(value = AccessType.FIELD)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class MiniVan extends Vehicle {

  @Column(name="color")
  protected String color;

  public MiniVan(){
    super.setType("MiniVan");
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    MiniVan miniVan = (MiniVan) o;
    return Objects.equals(color, miniVan.color);
  }

  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), color);
  }
}
