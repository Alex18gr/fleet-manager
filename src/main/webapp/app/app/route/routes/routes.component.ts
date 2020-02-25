import {Component, OnInit, ViewChild} from '@angular/core';
import {Route} from "../../classes/route";
import {EditDriverModalComponent} from "../../shared/edit-driver-modal/edit-driver-modal.component";
import {RouteModalComponent} from "../route-modal/route-modal.component";

@Component({
  selector: 'app-routes',
  templateUrl: './routes.component.html',
  styleUrls: ['./routes.component.css']
})
export class RoutesComponent implements OnInit {
  @ViewChild('editModal', {static: false}) editModal: RouteModalComponent;
  routesList: Route[];

  constructor() { }

  ngOnInit(): void {
  }

  getData() {

  }

  createRoute() {
    this.editModal.showModal();
  }
}
