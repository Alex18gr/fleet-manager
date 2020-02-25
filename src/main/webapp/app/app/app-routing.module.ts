import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from "./home/home/home.component";
import {DriverComponent} from "./driver/driver/driver.component";
import {VehicleComponent} from "./vehicle/vehicle/vehicle.component";
import {VehicleDetailsComponent} from "./vehicle/vehicle-details/vehicle-details.component";
import {RoutesComponent} from "./route/routes/routes.component";


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'drivers', component: DriverComponent},
  {path: 'vehicles', children: [
      {path: '', component: VehicleComponent},
      {path: ':id', component: VehicleDetailsComponent}
    ]},
  {path: 'routes', component: RoutesComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
