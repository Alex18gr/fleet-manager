package gr.edu.uom.fleetmanager.service;

import gr.edu.uom.fleetmanager.model.Employee;
import gr.edu.uom.fleetmanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  public Employee getEmployeeById(Long id){
    return employeeRepository.findById(id).orElse(null);
  }

  public Employee saveEmployee(Employee employee){
    return employeeRepository.save(employee);
  }

  public List<Employee> getAllEmployees(){
    return employeeRepository.findAll();
  }

  public void deleteEmployee(Long id){
    employeeRepository.deleteById(id);
  }

}
