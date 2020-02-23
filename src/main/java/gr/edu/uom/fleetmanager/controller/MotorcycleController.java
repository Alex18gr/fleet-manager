package gr.edu.uom.fleetmanager.controller;

import gr.edu.uom.fleetmanager.model.Motorcycle;
import gr.edu.uom.fleetmanager.service.MotorcycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motorcycle")
@CrossOrigin(value = "http://localhost:4200", maxAge = 3600)
public class MotorcycleController {

  @Autowired
  private MotorcycleService motorcycleService;

  @GetMapping("/{id}")
  public Motorcycle getMotorcycle(@PathVariable Long id) {
    return motorcycleService.getMotorcycleByLicencePlate(id);
  }

  @GetMapping(path = "/all")
  public List<Motorcycle> getAllClients() {
    return motorcycleService.getAllMotorcycles();
  }

  @PostMapping("")
  public Motorcycle createMotorcycle(@RequestBody Motorcycle motorcycle) {
    return motorcycleService.saveMotorcycle(motorcycle);
  }

  @PutMapping("")
  public Motorcycle updateMotorcycle(@RequestBody Motorcycle motorcycle) {
    return motorcycleService.saveMotorcycle(motorcycle);
  }

  @DeleteMapping("/{id}")
  public void deleteMotorcycle(@PathVariable Long id) {
    motorcycleService.deleteMotorcycle(id);
  }

}
