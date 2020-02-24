package gr.edu.uom.fleetmanager.model;

import javax.persistence.*;

@Entity
@Table(name = "route")
public class Route {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id")
  private Long id;

  @ManyToOne
  @JoinColumn(name="employee_id", nullable=true)
  private Employee employee;

  @ManyToOne
  @JoinColumn(name="client_id", nullable=true)
  private Client client;

  @ManyToOne
  @JoinColumn(name="minivan_id", nullable=true)
  private MiniVan miniVan;

  @ManyToOne
  @JoinColumn(name="motorcycle_id", nullable=true)
  private Motorcycle motorcycle;

  @ManyToOne
  @JoinColumn(name="taxi_id", nullable=true)
  private Taxi taxi;

  @Column(name = "destination", nullable=true)
  private String destination;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }

  public MiniVan getMiniVan() {
    return miniVan;
  }

  public void setMiniVan(MiniVan miniVan) {
    this.miniVan = miniVan;
  }

  public Motorcycle getMotorcycle() {
    return motorcycle;
  }

  public void setMotorcycle(Motorcycle motorcycle) {
    this.motorcycle = motorcycle;
  }

  public Taxi getTaxi() {
    return taxi;
  }

  public void setTaxi(Taxi taxi) {
    this.taxi = taxi;
  }
}
