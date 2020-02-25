package gr.edu.uom.fleetmanager.repository;

import gr.edu.uom.fleetmanager.model.Taxi;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaxiRepository extends CrudRepository<Taxi, Long> {
  List<Taxi> findAll();

  Taxi findOneById(Long id);
}
