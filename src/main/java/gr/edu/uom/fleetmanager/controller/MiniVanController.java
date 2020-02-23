package gr.edu.uom.fleetmanager.controller;

import gr.edu.uom.fleetmanager.model.MiniVan;
import gr.edu.uom.fleetmanager.service.MiniVanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/minivan")
@CrossOrigin(value = "http://localhost:4200", maxAge = 3600)
public class MiniVanController {

  @Autowired
  private MiniVanService miniVanService;

  @GetMapping("/{id}")
  public MiniVan getMiniVan(@PathVariable Long id) {
    return miniVanService.getMIniVanByLicencePlate(id);
  }

  @GetMapping(path = "/all")
  public List<MiniVan> getAllMiniVans() {
    return miniVanService.getAllMiniVans();
  }

  @PostMapping("")
  public MiniVan createMiniVan(@RequestBody MiniVan miniVan) {
    return miniVanService.saveMiniVan(miniVan);
  }

  @PutMapping("")
  public MiniVan updateMiniVan(@RequestBody MiniVan miniVan) {
    return miniVanService.saveMiniVan(miniVan);
  }

  @DeleteMapping("/{id}")
  public void deleteMiniVan(@PathVariable Long id) {
    miniVanService.deleteMiniVan(id);
  }

}
