package gr.edu.uom.fleetmanager.controller;

import gr.edu.uom.fleetmanager.model.Taxi;
import gr.edu.uom.fleetmanager.service.TaxiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/taxi")
public class TaxiController {

  @Autowired
  private TaxiService taxiService;

  @GetMapping("/{licencePlate}")
  public Taxi getTaxi(@PathVariable String licencePlate) {
    return taxiService.getTaxiByLicencePlate(licencePlate);
  }

  @GetMapping(path = "/all")
  public List<Taxi> getAllClients() {
    return taxiService.getAllTaxies();
  }

  @PostMapping("")
  public Taxi createTaxi(@RequestBody Taxi taxi) {
    return taxiService.saveTaxi(taxi);
  }

  @PutMapping("")
  public Taxi updateTaxi(@RequestBody Taxi taxi) {
    return taxiService.saveTaxi(taxi);
  }

  @DeleteMapping("/{licencePlate}")
  public void deleteTaxi(@PathVariable String licencePlate) {
    taxiService.deleteTaxi(licencePlate);
  }

}
