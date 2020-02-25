package gr.edu.uom.fleetmanager.controller;

import gr.edu.uom.fleetmanager.model.Client;
import gr.edu.uom.fleetmanager.model.Driver;
import gr.edu.uom.fleetmanager.model.Employee;
import gr.edu.uom.fleetmanager.service.ClientService;
import gr.edu.uom.fleetmanager.service.EmployeeService;
import gr.edu.uom.fleetmanager.service.MiniVanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/driver")
@CrossOrigin(value = "http://localhost:4200", maxAge = 3600)
public class DriverController {

  @Autowired
  private EmployeeService employeeService;

  @Autowired
  private ClientService clientService;

  @GetMapping(path = "/all")
  public List<Driver> getAllDrivers() {
    List<Driver> drivers = new ArrayList<>();

    List<Employee> employees = employeeService.getAllEmployees();
    List<Client> clients = clientService.getAllClients();


    employees.forEach(v -> drivers.add(v));
    clients.forEach(m -> drivers.add(m));

    return drivers;
  }
}
