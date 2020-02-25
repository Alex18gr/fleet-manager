package gr.edu.uom.fleetmanager.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "employee")
@Access(value=AccessType.FIELD)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Employee extends Driver {


  @Temporal(TemporalType.DATE)
  @Column(name="dt_started")
  private Date dtStarted;

  @Temporal(TemporalType.DATE)
  @Column(name="dt_stopped")
  private Date dtStopped;

  public Employee(){
    super.setType("Employee");
  }

  public Date getDtStarted() {
    return dtStarted;
  }

  public void setDtStarted(Date dtStarted) {
    this.dtStarted = dtStarted;
  }

  public Date getDtStopped() {
    return dtStopped;
  }

  public void setDtStopped(Date dtStopped) {
    this.dtStopped = dtStopped;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    Employee employee = (Employee) o;
    return Objects.equals(dtStarted, employee.dtStarted) &&
      Objects.equals(dtStopped, employee.dtStopped);
  }

  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), dtStarted, dtStopped);
  }
}
