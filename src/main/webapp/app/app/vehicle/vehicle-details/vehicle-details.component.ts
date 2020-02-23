import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {VehicleService, VehicleType} from "../vehicle.service";

@Component({
  selector: 'app-vehicle-details',
  templateUrl: './vehicle-details.component.html',
  styleUrls: ['./vehicle-details.component.css']
})
export class VehicleDetailsComponent implements OnInit {

  currentVehicleId: number;
  currentVehicleType: VehicleType;
  VehicleType = VehicleType;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private vehicleService: VehicleService) { }

  ngOnInit(): void {

    this.route.queryParamMap.subscribe(qparams => {
      this.currentVehicleType = +qparams.get('t');
      if (this.currentVehicleType !== 0 && Object.values(this.VehicleType).includes(this.currentVehicleType)) {
        this.route.paramMap.subscribe(params => {
          this.currentVehicleId = +params.get('id');

        });
      } else {
        this.router.navigate(['vehicles']);
      }
    });
  }

}
