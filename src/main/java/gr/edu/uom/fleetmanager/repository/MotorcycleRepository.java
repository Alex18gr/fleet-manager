package gr.edu.uom.fleetmanager.repository;

import gr.edu.uom.fleetmanager.model.Motorcycle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MotorcycleRepository extends CrudRepository<Motorcycle, Long> {
  List<Motorcycle> findAll();

  Motorcycle findOneById(Long id);
}
