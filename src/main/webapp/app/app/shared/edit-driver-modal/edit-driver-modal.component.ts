import {Component, ElementRef, EventEmitter, OnInit, Output, ViewChild} from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from "@angular/forms";
import {Driver} from "../../classes/models/driver";
import {DriverEmployee} from "../../classes/models/driver-employee";
import * as moment from 'moment';
import {DriverService} from "../../driver/driver.service";

declare var $: any;

@Component({
  selector: 'app-edit-driver-modal',
  templateUrl: './edit-driver-modal.component.html',
  styleUrls: ['./edit-driver-modal.component.css']
})
export class EditDriverModalComponent implements OnInit {
  @ViewChild('modal', {static: false}) editModal: ElementRef;
  @Output() editFormSubmitted = new EventEmitter<DriverEmployee>();
  employeeForm: FormGroup;
  savingData = false;
  editMode = false;
  currentEmployee: DriverEmployee;
  title = '';

  constructor(private driverService: DriverService) { }

  ngOnInit() {
    this.initForm();
  }

  /**
   * initialize the edit classroom form besed on the optional provided classroom or for a new classroom
   */
  initForm(employee?: DriverEmployee) {
    this.employeeForm = new FormGroup({
      name: new FormControl('', Validators.required),
      lastName: new FormControl('', Validators.required),
      dtReceived: new FormControl('', Validators.required),
      nationality: new FormControl('', Validators.required),
      address: new FormControl('', Validators.required),
      city: new FormControl('', Validators.required),
      dtStarted: new FormControl('', Validators.required),
      dtStopped: new FormControl('', Validators.required)
    });
    if (employee) {
      this.currentEmployee = employee;
      this.employeeForm.setValue({
        name: employee.name,
        lastName: employee.lastName,
        dtReceived: moment(employee.dtReceived).format('YYYY-MM-DD'),
        nationality: employee.nationality,
        address: employee.address,
        city: employee.city,
        dtStarted: moment(employee.dtStarted).format('YYYY-MM-DD'),
        dtStopped: moment(employee.dtStopped).format('YYYY-MM-DD')
      });
    } else {
      // this.currentEmployee = new D(0);
    }
  }

  /**
   * show the bootstrap modal using jQuery code and initialize the edit form
   */
  showModal(employee?: DriverEmployee) {
    $(this.editModal.nativeElement).modal();
    if (employee) {
      this.title = 'Edit Employee';
      this.editMode = true;
    } else {
      this.title = 'Create new Employee';
      this.editMode = false;
    }
    this.initForm(employee);
  }

  /**
   * hides the modal and reset the modal component variables
   */
  hideModal() {
    this.currentEmployee = null;
    this.savingData = false;
    this.title = '';
    this.editMode = false;
    this.employeeForm.reset();
    $(this.editModal.nativeElement).modal('hide');
  }

  formTouchedCondition(control: AbstractControl) {
    return control.invalid && (control.dirty || control.touched);
  }

  isInvalidControlCondition(control: AbstractControl) {
    return control.invalid && this.formTouchedCondition(control);
  }

  onSaveChanges() {
    console.log(this.employeeForm);
    if (this.editMode) {
      this.driverService.updateEmployeeDriver({
        id: this.currentEmployee.id,
        ...this.employeeForm.value
      }).subscribe(data => {
        this.editFormSubmitted.emit(data);
        this.hideModal();
      });
    } else {
      this.driverService.postEmployeeDriver(this.employeeForm.value).subscribe(data => {
        this.editFormSubmitted.emit(data);
        this.hideModal();
      });
    }
  }
}
