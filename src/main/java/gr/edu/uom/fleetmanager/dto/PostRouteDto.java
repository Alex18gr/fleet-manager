package gr.edu.uom.fleetmanager.dto;

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
