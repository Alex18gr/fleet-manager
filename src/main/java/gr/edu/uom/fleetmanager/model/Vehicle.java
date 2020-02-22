package gr.edu.uom.fleetmanager.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@MappedSuperclass
public class Vehicle {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id")
  protected Long id;

  @Column(name="type")
  protected String type;

  @Column(name = "licence_plate")
  protected String licencePlate;

  @Column(name = "model")
  protected String model;

  @Temporal(TemporalType.DATE)
  @Column(name = "model_year")
  protected Date modelYear;

  @Column(name = "kilometers")
  protected Integer kilometers;

  @Column(name = "capability_seat")
  private Integer capabilitySeat;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

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
    Vehicle vehicle = (Vehicle) o;
    return Objects.equals(id, vehicle.id) &&
      Objects.equals(type, vehicle.type) &&
      Objects.equals(licencePlate, vehicle.licencePlate) &&
      Objects.equals(model, vehicle.model) &&
      Objects.equals(modelYear, vehicle.modelYear) &&
      Objects.equals(kilometers, vehicle.kilometers) &&
      Objects.equals(capabilitySeat, vehicle.capabilitySeat);
  }

  @Override
  public int hashCode() {

    return Objects.hash(id, type, licencePlate, model, modelYear, kilometers, capabilitySeat);
  }
}
