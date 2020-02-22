package gr.edu.uom.fleetmanager.controller;

import gr.edu.uom.fleetmanager.model.MiniVan;
import gr.edu.uom.fleetmanager.model.Motorcycle;
import gr.edu.uom.fleetmanager.model.Taxi;
import gr.edu.uom.fleetmanager.model.Vehicle;
import gr.edu.uom.fleetmanager.service.MiniVanService;
import gr.edu.uom.fleetmanager.service.MotorcycleService;
import gr.edu.uom.fleetmanager.service.TaxiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

  @Autowired
  private MiniVanService miniVanService;

  @Autowired
  private MotorcycleService motorcycleService;

  @Autowired
  private TaxiService taxiService;

  @GetMapping(path = "/all")
  public List<Vehicle> getAllVehicles() {
    List<Vehicle> vehicles = new ArrayList<>();

    List<MiniVan> minivans = miniVanService.getAllMiniVans();
    List<Motorcycle> motorcycle = motorcycleService.getAllMotorcycles();
    List<Taxi> taxis = taxiService.getAllTaxies();


    minivans.forEach(v -> vehicles.add(v));
    motorcycle.forEach(m -> vehicles.add(m));
    taxis.forEach(t -> vehicles.add(t));


    return vehicles;
  }

  }
