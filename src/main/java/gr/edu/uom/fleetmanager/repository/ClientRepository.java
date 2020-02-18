package gr.edu.uom.fleetmanager.repository;

import gr.edu.uom.fleetmanager.model.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientRepository extends CrudRepository<Client, Long> {
  List<Client> findAll();
}
