package gr.edu.uom.fleetmanager.dto;

public class DriverStatisticDto {

  private String fullName;

  private Long totalRoutes;

  public DriverStatisticDto() {

  }
  public DriverStatisticDto(String fullName, Long totalRoutes) {
    this.fullName = fullName;
    this.totalRoutes = totalRoutes;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public Long getTotalRoutes() {
    return totalRoutes;
  }

  public void setTotalRoutes(Long totalRoutes) {
    this.totalRoutes = totalRoutes;
  }
}
