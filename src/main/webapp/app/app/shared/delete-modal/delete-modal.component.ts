import {Component, ElementRef, EventEmitter, OnInit, Output, ViewChild} from '@angular/core';
import {DriverEmployee} from "../../classes/models/driver-employee";
import {Driver} from "../../classes/models/driver";
import {DriverService} from "../../driver/driver.service";

declare var $: any;

@Component({
  selector: 'app-delete-modal',
  templateUrl: './delete-modal.component.html',
  styleUrls: ['./delete-modal.component.css']
})
export class DeleteModalComponent implements OnInit {
  @ViewChild('modal', {static: false}) deleteModal: ElementRef;
  @Output() editFormSubmitted = new EventEmitter<any>();
  deletingData = false;
  // deleteClassroomMode = false;
  deletingComponent: Driver | DriverEmployee;
  title = '';
  message = '';

  constructor(private driverService: DriverService) { }

  ngOnInit(): void {
  }

  /**
   * show the bootstrap modal using jQuery code for deleting the provided classroom
   */
  showDriverEmployeeDeleteModal(component: DriverEmployee) {
    this.deletingComponent = component;
    this.title = 'Delete Driver Employee ' + this.deletingComponent.name; + ' ' + this.deletingComponent.lastName;
    this.message = 'Are you sure you want to delete Employee' + this.deletingComponent.name; +
      ' ' + this.deletingComponent.lastName + '?';
    $(this.deleteModal.nativeElement).modal();
  }

  /**
   * show the bootstrap modal using jQuery code for deleting the provided student
   */
  // showStudentDeleteModal(component: Student, currentClassroom: Classroom) {
  //   this.deletingComponent = component;
  //   this.deleteClassroomMode = false;
  //   this.currentClassroom = currentClassroom;
  //   this.title = 'Delete Student ' + this.deletingComponent.firstName + ' ' + this.deletingComponent.lastName;
  //   this.message = 'Are you sure you want to delete student ' + this.deletingComponent.firstName + ' '
  //     + this.deletingComponent.lastName + '?';
  //   $(this.deleteModal.nativeElement).modal();
  // }

  /**
   * hides the modal using jQuery code and reset the modal component values
   */
  hideModal() {
    this.deletingComponent = null;
    this.title = '';
    this.message = '';
    $(this.deleteModal.nativeElement).modal('hide');
  }

  onDelete() {
    this.driverService.deleteEmployeeDriver(this.deletingComponent as DriverEmployee).subscribe(data => {
      this.editFormSubmitted.emit(data);
      this.hideModal();
    })
  }
}
