package gr.edu.uom.fleetmanager.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@MappedSuperclass
public class Vehicle {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id")
  private Long id;

  @Column(name = "licence_plate")
  private String licencePlate;

  @Column(name = "model")
  private String model;

  @Temporal(TemporalType.DATE)
  @Column(name = "model_year")
  private Date modelYear;

  @Column(name = "kilometers")
  private Integer kilometers;

  public String getLicencePlate() {
    return licencePlate;
  }

  public void setLicencePlate(String licencePlate) {
    this.licencePlate = licencePlate;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public Date getModelYear() {
    return modelYear;
  }

  public void setModelYear(Date modelYear) {
    this.modelYear = modelYear;
  }

  public Integer getKilometers() {
    return kilometers;
  }

  public void setKilometers(Integer kilometers) {
    this.kilometers = kilometers;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Vehicle vehicle = (Vehicle) o;
    return Objects.equals(licencePlate, vehicle.licencePlate) &&
      Objects.equals(model, vehicle.model) &&
      Objects.equals(modelYear, vehicle.modelYear) &&
      Objects.equals(kilometers, vehicle.kilometers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(licencePlate, model, modelYear, kilometers);
  }
}
