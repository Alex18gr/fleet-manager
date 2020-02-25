package gr.edu.uom.fleetmanager.controller;

import gr.edu.uom.fleetmanager.dto.PostRouteDto;
import gr.edu.uom.fleetmanager.model.Route;
import gr.edu.uom.fleetmanager.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/route")
@CrossOrigin(value = "http://localhost:4200", maxAge = 3600)
public class RouteController {

  @Autowired
  private RouteService routeService;

  @GetMapping("/{id}")
  public Route getRoute(@PathVariable Long id) {
    return routeService.getRouteById(id);
  }

  @GetMapping(path = "/all")
  public List<PostRouteDto> getAllRoutes() {

    List<PostRouteDto> postRouteDtos = new ArrayList<>();

    routeService.getAllRoutes().forEach(r -> postRouteDtos.add(new PostRouteDto(r)));

    return  postRouteDtos;
  }

//  @PostMapping("")
//  public Route createRoute(@RequestBody Route route) {
//    return routeService.saveRoute(route);
//  }

  @PutMapping("")
  public Route updateRoute(@RequestBody Route route) {
    return routeService.saveRoute(route);
  }

  @DeleteMapping("/{id}")
  public void deleteRoute(@PathVariable Long id) {
    routeService.deleteRoute(id);
  }

  @PostMapping("")
  public Route createRoute(@RequestBody PostRouteDto postRouteDto) {
    return routeService.saveRouteDto(postRouteDto);
  }
}
