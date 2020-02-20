package gr.edu.uom.fleetmanager.repository;

import gr.edu.uom.fleetmanager.model.Motorcycle;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MotorcycleRepository extends CrudRepository<Motorcycle, String> {
  List<Motorcycle> findAll();
}
