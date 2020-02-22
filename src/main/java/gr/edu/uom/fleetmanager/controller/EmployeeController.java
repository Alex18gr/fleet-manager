package gr.edu.uom.fleetmanager.controller;

import gr.edu.uom.fleetmanager.model.Employee;
import gr.edu.uom.fleetmanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @GetMapping("/{id}")
  public Employee getEmployee(@PathVariable Long id) {
    return employeeService.getEmployeeById(id);
  }

  @GetMapping(path = "/all")
  public List<Employee> getAllClients() {
    return employeeService.getAllEmployees();
  }

  @PostMapping("")
  public Employee createEmployee(@RequestBody Employee employee) {

    employee.setId(null);
    return employeeService.saveEmployee(employee);
  }

  @PutMapping("")
  public Employee updateEmployee(@RequestBody Employee employee) {
    return employeeService.saveEmployee(employee);
  }

  @DeleteMapping("/{id}")
  public void deleteEmployee(@PathVariable Long id) {
    employeeService.deleteEmployee(id);
  }


}
