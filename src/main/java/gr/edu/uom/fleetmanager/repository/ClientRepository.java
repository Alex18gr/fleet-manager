package gr.edu.uom.fleetmanager.repository;

import gr.edu.uom.fleetmanager.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
  List<Client> findAll();

  Client findOneById(Long id);
}
