package gr.edu.uom.fleetmanager.repository;

import gr.edu.uom.fleetmanager.model.MiniVan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MiniVanRepository extends JpaRepository<MiniVan, Long> {
  List<MiniVan> findAll();



}
