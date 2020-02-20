package gr.edu.uom.fleetmanager.controller;

import gr.edu.uom.fleetmanager.model.Taxi;
import gr.edu.uom.fleetmanager.service.TaxiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/taxi")
public class TaxiController {

  @Autowired
  private TaxiService taxiService;

  @GetMapping("/{licencePlate}")
  public Taxi getTaxi(@PathVariable String licencePlate) {
    return taxiService.getTaxiByLicencePlate(licencePlate);
  }

  @PostMapping("")
  public Taxi createTaxi(@RequestBody Taxi taxi) {
    taxi.setLicencePlate(null);
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
