package gr.edu.uom.fleetmanager.controller;

import gr.edu.uom.fleetmanager.model.Motorcycle;
import gr.edu.uom.fleetmanager.service.MotorcycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motorcycle")
public class MotorcycleController {

  @Autowired
  private MotorcycleService motorcycleService;

  @GetMapping("/{licencePlate}")
  public Motorcycle getMotorcycle(@PathVariable String licencePlate) {
    return motorcycleService.getMotorcycleByLicencePlate(licencePlate);
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

  @DeleteMapping("/{licencePlate}")
  public void deleteMotorcycle(@PathVariable String licencePlate) {
    motorcycleService.deleteMotorcycle(licencePlate);
  }

}
