package gr.edu.uom.fleetmanager.controller;

import gr.edu.uom.fleetmanager.model.Client;
import gr.edu.uom.fleetmanager.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/client")
public class ClientController {

  @Autowired
  private ClientService clientService;

  @GetMapping("/{id}")
  public Client getClient(@PathVariable Long id) {
    return clientService.getClientById(id);
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
