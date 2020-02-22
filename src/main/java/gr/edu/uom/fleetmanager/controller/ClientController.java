package gr.edu.uom.fleetmanager.controller;

import gr.edu.uom.fleetmanager.model.Client;
import gr.edu.uom.fleetmanager.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

  @Autowired
  private ClientService clientService;

  @GetMapping(path = "/{id}")
  public Client getClient(@PathVariable Long id) {
    return clientService.getClientById(id);
  }

  @GetMapping(path = "/all")
  public List<Client> getAllClients() {
    return clientService.getAllClients();
  }

  @PostMapping("")
  public Client createClient(@RequestBody Client client) {
    client.setId(null);
    return clientService.saveClient(client);
  }

  @PutMapping("")
  public Client updateClient(@RequestBody Client client) {
    return clientService.saveClient(client);
  }

  @DeleteMapping("/{id}")
  public void deleteClient(@PathVariable Long id) {
    clientService.deleteClient(id);
  }

}
