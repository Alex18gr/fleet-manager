import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {DriverEmployee} from "../../classes/models/driver-employee";

@Component({
  selector: 'app-driver-list',
  templateUrl: './driver-list.component.html',
  styleUrls: ['./driver-list.component.css']
})
export class DriverListComponent implements OnInit {
  @Output() onDelete: EventEmitter<DriverEmployee> = new EventEmitter<DriverEmployee>();
  @Output() onEdit: EventEmitter<DriverEmployee> = new EventEmitter<DriverEmployee>();

  @Input() employeesList: DriverEmployee[];

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
