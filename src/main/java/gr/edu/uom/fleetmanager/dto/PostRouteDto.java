package gr.edu.uom.fleetmanager.dto;

import gr.edu.uom.fleetmanager.model.Route;

/**
 * POJO used to create a new route,
 * containing the minimum required elements
 */
public class PostRouteDto {

  private Long d_id;
  private String d_type;
  private Long v_id;
  private String v_type;

  private String destination;

  private String d_full_name;
  private String v_plate;

  public PostRouteDto() {
  }

  public PostRouteDto(Route route) {

    if(route.getEmployee() != null){
      this.d_id = route.getEmployee().getId();
      this.d_type = route.getEmployee().getType();
      this.d_full_name = route.getEmployee().getName() + " " + route.getEmployee().getLastName();
    } else if(route.getClient() != null){
      this.d_id = route.getClient().getId();
      this.d_type = route.getClient().getType();
      this.d_full_name = route.getClient().getName() + " " + route.getClient().getLastName();
    }

    if(route.getMotorcycle() != null){
      this.v_id = route.getMotorcycle().getId();
      this.v_type = route.getMotorcycle().getType();
      this.v_plate= route.getMotorcycle().getLicencePlate();
    } else if(route.getMiniVan() != null){
      this.v_id = route.getMiniVan().getId();
      this.v_type = route.getMiniVan().getType();
      this.v_plate= route.getMiniVan().getLicencePlate();
    } else if(route.getTaxi() != null){
      this.v_id = route.getTaxi().getId();
      this.v_type = route.getTaxi().getType();
      this.v_plate= route.getTaxi().getLicencePlate();
    }

    this.destination = route.getDestination();

  }

  public Long getD_id() {
    return d_id;
  }

  public void setD_id(Long d_id) {
    this.d_id = d_id;
  }

  public String getD_type() {
    return d_type;
  }

  public void setD_type(String d_type) {
    this.d_type = d_type;
  }

  public Long getV_id() {
    return v_id;
  }

  public void setV_id(Long v_id) {
    this.v_id = v_id;
  }

  public String getV_type() {
    return v_type;
  }

  public void setV_type(String v_type) {
    this.v_type = v_type;
  }

  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }

  public String getD_full_name() {
    return d_full_name;
  }

  public void setD_full_name(String d_full_name) {
    this.d_full_name = d_full_name;
  }

  public String getV_plate() {
    return v_plate;
  }

  public void setV_plate(String v_plate) {
    this.v_plate = v_plate;
  }
}
