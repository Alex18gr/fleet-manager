package gr.edu.uom.fleetmanager.controller;

import gr.edu.uom.fleetmanager.model.Taxi;
import gr.edu.uom.fleetmanager.service.TaxiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/taxi")
@CrossOrigin(value = "http://localhost:4200", maxAge = 3600)
public class TaxiController {

  @Autowired
  private TaxiService taxiService;

  @GetMapping("/{id}")
  public Taxi getTaxi(@PathVariable Long id) {
    return taxiService.getTaxiById(id);
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

  @DeleteMapping("/{id}")
  public void deleteTaxi(@PathVariable Long id) {
    taxiService.deleteTaxi(id);
  }

}
