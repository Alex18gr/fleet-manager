package gr.edu.uom.fleetmanager.service;

import gr.edu.uom.fleetmanager.model.Motorcycle;
import gr.edu.uom.fleetmanager.repository.MotorcycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotorcycleService {

  @Autowired
  private MotorcycleRepository motorcycleRepository;

  public List<Motorcycle> getAllMotorcycles() {
    return motorcycleRepository.findAll();
  }

  public Motorcycle getMotorcycleByLicencePlate(String licencePlate) {
    return motorcycleRepository.findById(licencePlate).orElse(null);
  }

  public Motorcycle saveMotorcycle(Motorcycle motorcycle) {
    return motorcycleRepository.save(motorcycle);
  }

  public void deleteMotorcycle(String licencePlate) {
    motorcycleRepository.deleteById(licencePlate);
  }
}
