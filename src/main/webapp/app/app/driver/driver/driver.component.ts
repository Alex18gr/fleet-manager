import {Component, OnInit, ViewChild} from '@angular/core';
import {DriverEmployee} from "../../classes/models/driver-employee";
import {DeleteModalComponent} from "../../shared/delete-modal/delete-modal.component";
import {EditDriverModalComponent} from "../../shared/edit-driver-modal/edit-driver-modal.component";
import {DriverService} from "../driver.service";

@Component({
  selector: 'app-driver',
  templateUrl: './driver.component.html',
  styleUrls: ['./driver.component.css']
})
export class DriverComponent implements OnInit {
  @ViewChild('deleteModal', {static: false}) deleteModal: DeleteModalComponent;
  @ViewChild('editModal', {static: false}) editModal: EditDriverModalComponent;
  employeeList: DriverEmployee[];

  constructor(private driverService: DriverService) { }

  ngOnInit(): void {
    this.getData();
  }

  onEmployeeDelete(e: DriverEmployee) {
    this.deleteModal.showDriverEmployeeDeleteModal(e);
  }

  onEmployeeEdit(employee: DriverEmployee) {
    this.editModal.showModal(employee);
  }

  createEmployee() {
    this.editModal.showModal();
  }

  private getData() {
    this.employeeList = null;
    this.driverService.getAllEmployeeDrivers().subscribe(data => {
      this.employeeList = data;
    });
  }
}
