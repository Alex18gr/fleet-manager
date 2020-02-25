import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Route} from "../classes/route";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class RouteService {
  api_path: string = 'http://localhost:8080/';

  constructor(private http: HttpClient) { }

  postNewRoute(route: Route): Observable<any> {
    return this.http.post(this.api_path + 'route', route);
  }

  getAllRoutes() {
    return this.http.get<Route[]>(this.api_path + 'route/all')
  }
}
