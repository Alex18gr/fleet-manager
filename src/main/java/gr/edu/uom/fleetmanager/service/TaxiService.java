package gr.edu.uom.fleetmanager.service;

import gr.edu.uom.fleetmanager.model.Taxi;
import gr.edu.uom.fleetmanager.repository.TaxiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxiService {

  @Autowired
  private TaxiRepository taxiRepository;

  public List<Taxi> getAllTaxies() {
    return taxiRepository.findAll();
  }

  public Taxi saveTaxi(Taxi taxi) {
    return taxiRepository.save(taxi);
  }

  public void deleteTaxi(Long id) {
    taxiRepository.deleteById(id);
  }

  public Taxi getTaxiById(Long id) {
    return this.taxiRepository.findById(id).orElseThrow(RuntimeException::new);
  }
}
