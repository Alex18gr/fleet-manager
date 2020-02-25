import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {DriverEmployee} from "../classes/models/driver-employee";
import {Driver} from "../classes/models/driver";

@Injectable({
  providedIn: 'root'
})
export class DriverService {
  api_path: string = 'http://localhost:8080/';

  constructor(private http: HttpClient) { }

  getAllEmployeeDrivers(): Observable<DriverEmployee[]> {
    return this.http.get<DriverEmployee[]>(this.api_path + 'employee/all');
  }

  postEmployeeDriver(employeeDriver: DriverEmployee): Observable<DriverEmployee> {
    return this.http.post<DriverEmployee>(this.api_path + 'employee', employeeDriver);
  }

  updateEmployeeDriver(employeeDriver: DriverEmployee): Observable<DriverEmployee> {
    return this.http.put<DriverEmployee>(this.api_path + 'employee', employeeDriver);
  }

  deleteEmployeeDriver(driverEmployee: DriverEmployee): Observable<any> {
    return this.http.delete(this.api_path + 'employee/' + driverEmployee.id);
  }

  getAllDrivers(): Observable<Driver[]> {
    return this.http.get<Driver[]>(this.api_path + 'driver/all');
  }
}
