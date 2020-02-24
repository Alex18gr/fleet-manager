package gr.edu.uom.fleetmanager.controller;

import gr.edu.uom.fleetmanager.model.Route;
import gr.edu.uom.fleetmanager.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/route")
@CrossOrigin(value = "http://localhost:4200", maxAge = 3600)
public class RouteController {

  @Autowired
  private RouteService routeService;

  @GetMapping("/{id}")
  public Route getTaxi(@PathVariable Long id) {
    return routeService.getRouteById(id);
  }

  @GetMapping(path = "/all")
  public List<Route> getAllClients() {
    return routeService.getAllRoutes();
  }

  @PostMapping("")
  public Route createTaxi(@RequestBody Route taxi) {
    return routeService.saveRoute(taxi);
  }

  @PutMapping("")
  public Route updateTaxi(@RequestBody Route taxi) {
    return routeService.saveRoute(taxi);
  }

  @DeleteMapping("/{id}")
  public void deleteTaxi(@PathVariable Long id) {
    routeService.deleteRoute(id);
  }

}
