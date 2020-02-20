package gr.edu.uom.fleetmanager.service;

import gr.edu.uom.fleetmanager.model.Client;
import gr.edu.uom.fleetmanager.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

  @Autowired
  private ClientRepository clientRepository;

  public List<Client> getAllClients() {
    return clientRepository.findAll();
  }

  public Client getClientById(Long id) {
    return clientRepository.findById(id).orElse(null);
  }

  public Client saveClient(Client client) {
    return clientRepository.save(client);
  }

  public void deleteClient(Long id) {
    clientRepository.deleteById(id);
  }
}
