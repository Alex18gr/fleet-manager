import { Component, OnInit } from '@angular/core';
import {Route} from "../../classes/route";

@Component({
  selector: 'app-routes',
  templateUrl: './routes.component.html',
  styleUrls: ['./routes.component.css']
})
export class RoutesComponent implements OnInit {
  routesList: Route[];

  constructor() { }

  ngOnInit(): void {
  }

}
