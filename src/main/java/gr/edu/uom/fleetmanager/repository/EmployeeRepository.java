package gr.edu.uom.fleetmanager.repository;

import gr.edu.uom.fleetmanager.model.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    List<Employee> findAll();
}
