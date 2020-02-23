import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {VehicleService, VehicleType} from "../vehicle.service";
import {Vehicle} from "../../classes/vehicle";
import {VehicleMoto} from "../../classes/vehicle-moto";
import {VehicleTaxi} from "../../classes/vehicle-taxi";
import {VehicleVan} from "../../classes/vehicle-van";

@Component({
  selector: 'app-vehicle-details',
  templateUrl: './vehicle-details.component.html',
  styleUrls: ['./vehicle-details.component.css']
})
export class VehicleDetailsComponent implements OnInit {

  currentVehicleId: number;
  currentVehicleType: VehicleType;
  VehicleType = VehicleType;
  currentVehicle: any; // Vehicle | VehicleMoto | VehicleTaxi | VehicleVan;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private vehicleService: VehicleService) { }

  ngOnInit(): void {

    this.route.queryParamMap.subscribe(qparams => {
      this.currentVehicleType = +qparams.get('t');
      if (this.currentVehicleType !== 0 && Object.values(this.VehicleType).includes(this.currentVehicleType)) {
        this.route.paramMap.subscribe(params => {
          this.currentVehicleId = +params.get('id');
          this.vehicleService.getVehicleDetails(this.currentVehicleId, this.currentVehicleType).subscribe(data => {
            this.currentVehicle = data;
          });
        });
      } else {
        this.router.navigate(['vehicles']);
      }
    });
  }

  checkType(vehicleType: VehicleType): boolean {
    return this.vehicleService.getTypeEnum(this.currentVehicle.type) === vehicleType;
  }

}
