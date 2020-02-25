package gr.edu.uom.fleetmanager.service;


import gr.edu.uom.fleetmanager.model.Driver;
import gr.edu.uom.fleetmanager.model.Route;
import gr.edu.uom.fleetmanager.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class DriverService {

  @Autowired
  RouteRepository routeRepository;

  public HashMap<String, Long> getDriverStatistics(){

    HashMap<String, Long> stats = new HashMap<>();

    List<Route> routeList = routeRepository.findAll();
    for (Route route : routeList) {
      gr.edu.uom.fleetmanager.model.Driver driver = new Driver();

      if(route.getEmployee() != null) {
        driver = route.getEmployee();
      } else if(route.getClient() != null) {
        driver = route.getClient();
      }


      String fullName = driver.getName() + " " + driver.getLastName();
      if(!stats.containsKey(fullName)) {
        stats.put(fullName, 1L);
      } else{
        stats.put(fullName, (stats.get(fullName)) + 1 );
      }
    }

    return stats;

  }

}
