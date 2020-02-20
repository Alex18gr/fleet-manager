package gr.edu.uom.fleetmanager.controller;

import gr.edu.uom.fleetmanager.model.MiniVan;
import gr.edu.uom.fleetmanager.service.MiniVanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/minivan")
public class MiniVanController {

  @Autowired
  private MiniVanService miniVanService;

  @GetMapping("/{licencePlate}")
  public MiniVan getMiniVan(@PathVariable String licencePlate) {
    return miniVanService.getMIniVanByLicencePlate(licencePlate);
  }

  @PostMapping("")
  public MiniVan createMiniVan(@RequestBody MiniVan miniVan) {
    miniVan.setLicencePlate(null);
    return miniVanService.saveMiniVan(miniVan);
  }

  @PutMapping("")
  public MiniVan updateMiniVan(@RequestBody MiniVan miniVan) {
    return miniVanService.saveMiniVan(miniVan);
  }

  @DeleteMapping("/{licencePlate}")
  public void deleteMiniVan(@PathVariable String licencePlate) {
    miniVanService.deleteMiniVan(licencePlate);
  }

}
