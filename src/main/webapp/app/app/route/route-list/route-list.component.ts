import {Component, Input, OnInit} from '@angular/core';
import {Route} from "../../classes/route";

@Component({
  selector: 'app-route-list',
  templateUrl: './route-list.component.html',
  styleUrls: ['./route-list.component.css']
})
export class RouteListComponent implements OnInit {
  @Input() routesList: Route[];

  constructor() { }

  ngOnInit(): void {
  }

}
