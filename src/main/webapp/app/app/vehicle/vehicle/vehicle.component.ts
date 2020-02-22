import { Component, OnInit } from '@angular/core';
import {Vehicle} from "../../classes/vehicle";
import {VehicleService} from "../vehicle.service";

@Component({
  selector: 'app-vehicle',
  templateUrl: './vehicle.component.html',
  styleUrls: ['./vehicle.component.css']
})
export class VehicleComponent implements OnInit {
  vehiclesList: Vehicle[];

  constructor(private vehicleService: VehicleService) { }

  ngOnInit(): void {
    this.getVehicleData();
  }

  getVehicleData() {
    this.vehicleService.getAllVehicles().subscribe(data => {
      this.vehiclesList = data;
    });
  }

}
