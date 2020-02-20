package gr.edu.uom.fleetmanager.service;

import gr.edu.uom.fleetmanager.model.MiniVan;
import gr.edu.uom.fleetmanager.repository.MiniVanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MiniVanService {

  @Autowired
  private MiniVanRepository miniVanRepository;

  public List<MiniVan> getAllMiniVans() {
    return miniVanRepository.findAll();
  }

  public MiniVan getMIniVanByLicencePlate(String licencePlate) {
    return miniVanRepository.findById(licencePlate).orElse(null);
  }

  public MiniVan saveMiniVan(MiniVan miniVan) {
    return miniVanRepository.save(miniVan);
  }

  public void deleteMiniVan(String licencePlate) {
    miniVanRepository.deleteById(licencePlate);
  }
}
