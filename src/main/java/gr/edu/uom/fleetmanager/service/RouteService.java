package gr.edu.uom.fleetmanager.service;

import gr.edu.uom.fleetmanager.dto.PostRouteDto;
import gr.edu.uom.fleetmanager.model.Route;
import gr.edu.uom.fleetmanager.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {

  @Autowired
  private RouteRepository routeRepository;

  @Autowired
  private EmployeeRepository employeeRepository;

  @Autowired
  private ClientRepository clientRepository;

  @Autowired
  private MotorcycleRepository motorcycleRepository;

  @Autowired
  private TaxiRepository taxiRepository;

  @Autowired
  private MiniVanRepository miniVanRepository;

  public List<Route> getAllRoutes() {
    return routeRepository.findAll();
  }

  public Route getRouteById(Long id) {
    return routeRepository.findOneById(id);
  }

  public Route saveRoute(Route client) {
    return routeRepository.save(client);
  }

  public Route saveRouteDto(PostRouteDto postRouteDto) {

    Route route = new Route();

    //get driver based on id and type
    if(postRouteDto.getD_type().equals("Employee")){
      route.setEmployee(employeeRepository.findOneById(postRouteDto.getD_id()));
    }else if(postRouteDto.getD_type().equals("Client")){
      route.setClient(clientRepository.findOneById(postRouteDto.getD_id()));
    }

    //get vehicle based on id and type
    if(postRouteDto.getV_type().equals("Motorcycle")){
      route.setMotorcycle(motorcycleRepository.findOneById(postRouteDto.getD_id()));
    } else if(postRouteDto.getV_type().equals("Taxi")){
      route.setTaxi(taxiRepository.findOneById(postRouteDto.getD_id()));
    } else if(postRouteDto.getV_type().equals("MiniVan")){
      route.setMiniVan(miniVanRepository.findOneById(postRouteDto.getD_id()));
    }

    //add other route elements
    route.setDestination(postRouteDto.getDestination());

    return routeRepository.save(route);
  }


  public void deleteRoute(Long id) {
    routeRepository.deleteById(id);
  }
}
