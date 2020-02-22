package gr.edu.uom.fleetmanager.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "client")
@Access(value = AccessType.FIELD)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Client extends Driver {

  @Temporal(TemporalType.DATE)
  @Column(name = "start_booking")
  private Date startDateBooking;

  @Temporal(TemporalType.DATE)
  @Column(name = "end_booking")
  private Date endDateBooking;


  public Date getStartDateBooking() {
    return startDateBooking;
  }

  public void setStartDateBooking(Date startDateBooking) {
    this.startDateBooking = startDateBooking;
  }

  public Date getEndDateBooking() {
    return endDateBooking;
  }

  public void setEndDateBooking(Date endDateBooking) {
    this.endDateBooking = endDateBooking;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    Client client = (Client) o;
    return Objects.equals(startDateBooking, client.startDateBooking) &&
      Objects.equals(endDateBooking, client.endDateBooking);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), startDateBooking, endDateBooking);
  }
}
