package gr.edu.uom.fleetmanager.repository;

import gr.edu.uom.fleetmanager.model.Taxi;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaxiRepository extends CrudRepository<Taxi, String> {
  List<Taxi> findAll();
}
