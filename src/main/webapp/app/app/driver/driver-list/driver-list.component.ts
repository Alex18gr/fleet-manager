import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {DriverEmployee} from "../../classes/models/driver-employee";

@Component({
  selector: 'app-driver-list',
  templateUrl: './driver-list.component.html',
  styleUrls: ['./driver-list.component.css']
})
export class DriverListComponent implements OnInit {
  @Output() onDelete: EventEmitter<DriverEmployee> = new EventEmitter<DriverEmployee>();
  @Output() onEdit: EventEmitter<DriverEmployee> = new EventEmitter<DriverEmployee>();

  employeesList: DriverEmployee[] = [{
    id: 1,
    firstName: 'PAOK',
    lastName: 'OLE',
    dt_started: new Date('2005-07-25T09:07:20.143Z'),
    dt_stopped: new Date('11-02-1990')
  }];

  constructor() { }

  ngOnInit(): void {
  }

  deleteDriver(e: DriverEmployee) {
    this.onDelete.emit(e);
  }

  editDriver(e: DriverEmployee) {
    this.onEdit.emit(e);
  }
}
