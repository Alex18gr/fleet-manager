package gr.edu.uom.fleetmanager.service;

import gr.edu.uom.fleetmanager.model.Route;
import gr.edu.uom.fleetmanager.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {

  @Autowired
  private RouteRepository routeRepository;

  public List<Route> getAllRoutes() {
    return routeRepository.findAll();
  }

  public Route getRouteById(Long id) {
    return routeRepository.findOneById(id);
  }

  public Route saveRoute(Route client) {
    return routeRepository.save(client);
  }

  public void deleteRoute(Long id) {
    routeRepository.deleteById(id);
  }
}
