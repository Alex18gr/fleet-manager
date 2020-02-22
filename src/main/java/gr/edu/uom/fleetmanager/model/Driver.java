package gr.edu.uom.fleetmanager.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@MappedSuperclass
public class Driver {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name="name")
  private String name;

  @Column(name="last_name", length=250)
  private String lastName;

  @Temporal(TemporalType.DATE)
  @Column(name="dt_received")
  private Date dtReceived;

  @Column(name="nationality", length=250)
  private String nationality;

  @Column(name="address", length=250)
  private String address;

  @Column(name="city", length=250)
  private String city;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Date getDtReceived() {
    return dtReceived;
  }

  public void setDtReceived(Date dtReceived) {
    this.dtReceived = dtReceived;
  }

  public String getNationality() {
    return nationality;
  }

  public void setNationality(String nationality) {
    this.nationality = nationality;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Driver driver = (Driver) o;
    return Objects.equals(id, driver.id) &&
      Objects.equals(name, driver.name) &&
      Objects.equals(lastName, driver.lastName) &&
      Objects.equals(dtReceived, driver.dtReceived) &&
      Objects.equals(nationality, driver.nationality) &&
      Objects.equals(address, driver.address) &&
      Objects.equals(city, driver.city);
  }

  @Override
  public int hashCode() {

    return Objects.hash(id, name, lastName, dtReceived, nationality, address, city);
  }
}
