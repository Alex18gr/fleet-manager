package gr.edu.uom.fleetmanager.repository;

import gr.edu.uom.fleetmanager.model.Route;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends CrudRepository<Route, Long> {

  List<Route> findAll();

  Route findOneById(Long id);

}
