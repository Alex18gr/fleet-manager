import {Component, ElementRef, EventEmitter, OnInit, Output, ViewChild} from '@angular/core';
import {DriverEmployee} from "../../classes/models/driver-employee";
import {AbstractControl, FormControl, FormGroup, Validators} from "@angular/forms";
import {DriverService} from "../../driver/driver.service";
import * as moment from "moment";
import {Vehicle} from "../../classes/vehicle";

declare var $: any;

@Component({
  selector: 'app-edit-vehicle-modal',
  templateUrl: './edit-vehicle-modal.component.html',
  styleUrls: ['./edit-vehicle-modal.component.css']
})
export class EditVehicleModalComponent implements OnInit {

  @ViewChild('modal', {static: false}) editModal: ElementRef;
  @Output() editFormSubmitted = new EventEmitter<DriverEmployee>();
  // employeeForm: FormGroup;
  savingData = false;
  editMode = false;
  currentVehicle: Vehicle;
  title = '';

  constructor(private driverService: DriverService) { }

  ngOnInit() {
    this.initForm();
  }

  /**
   * initialize the edit classroom form besed on the optional provided classroom or for a new classroom
   */
  initForm(vehicle?: Vehicle) {
    if (vehicle) {

    } else {
      // this.currentEmployee = new D(0);
    }
  }

  /**
   * show the bootstrap modal using jQuery code and initialize the edit form
   */
  showModal(vehicle?: Vehicle) {
    $(this.editModal.nativeElement).modal();
    if (vehicle) {
      this.title = 'Edit Employee';
      this.editMode = true;
    } else {
      this.title = 'Create new Employee';
      this.editMode = false;
    }
    // this.initForm(employee);
  }

  /**
   * hides the modal and reset the modal component variables
   */
  hideModal() {
    this.currentVehicle = null;
    this.savingData = false;
    this.title = '';
    this.editMode = false;
    // this.employeeForm.reset();
    $(this.editModal.nativeElement).modal('hide');
  }

  formTouchedCondition(control: AbstractControl) {
    return control.invalid && (control.dirty || control.touched);
  }

  isInvalidControlCondition(control: AbstractControl) {
    return control.invalid && this.formTouchedCondition(control);
  }

  onSaveChanges() {
    // console.log(this.employeeForm);
    if (this.editMode) {

    } else {

    }
  }

}
