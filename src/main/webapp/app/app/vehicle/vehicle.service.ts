import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Vehicle} from "../classes/vehicle";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class VehicleService {
  api_path: string = 'http://localhost:8080/';

  constructor(private http: HttpClient) { }

  getAllVehicles(): Observable<Vehicle[]> {
    return this.http.get<Vehicle[]>(this.api_path + 'vehicle/all');
  }

  getVehicleDetails(id: number, type: VehicleType): Observable<Vehicle> {
    return this.http.get<Vehicle>(this.api_path + this.getVehicleUrl(type) + '/' + id);
  }

  getTypeEnum(type: string): VehicleType {
    switch (type) {
      case 'MiniVan':
        return VehicleType.MINI_VAN;
      case 'Motorcycle':
        return VehicleType.MOTORCYCLE;
      case 'Taxi':
        return VehicleType.TAXI;
      default:
        return VehicleType.NONE;
    }
  }

  getVehicleUrl(type: VehicleType): string {
    switch (type) {
      case VehicleType.MINI_VAN:
        return 'minivan/';
      case VehicleType.MOTORCYCLE:
        return 'motorcycle/';
      case VehicleType.TAXI:
        return 'taxi/';
      default:
        return '';
    }
  }
}

export enum VehicleType {
  NONE,
  MINI_VAN,
  MOTORCYCLE,
  TAXI
}
