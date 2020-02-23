import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Vehicle} from "../../classes/vehicle";
import {DriverEmployee} from "../../classes/models/driver-employee";
import {ActivatedRoute, Router} from "@angular/router";
import {VehicleService} from "../vehicle.service";

@Component({
  selector: 'app-vehicle-list',
  templateUrl: './vehicle-list.component.html',
  styleUrls: ['./vehicle-list.component.css']
})
export class VehicleListComponent implements OnInit {
  @Output() onEdit: EventEmitter<Vehicle> = new EventEmitter<Vehicle>();
  @Output() onDelete: EventEmitter<Vehicle> = new EventEmitter<Vehicle>();
  @Input() vehicleList: Vehicle[];

  constructor(private router: Router,
              private route: ActivatedRoute,
              private vehicleService: VehicleService) { }

  ngOnInit(): void {
  }

  deleteVehicle(v: Vehicle) {
    this.onDelete.emit(v);
  }

  editVehicle(v: Vehicle) {
    this.onEdit.emit(v);
  }

  vehicleDetails(v: Vehicle) {
    // this.router.navigate([v.id], {relativeTo: this.route, queryParams: {t: this.vehicleService.getTypeEnum(v.type)}});
  }
}
