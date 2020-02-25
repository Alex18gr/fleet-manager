import {Component, ElementRef, EventEmitter, OnInit, Output, ViewChild} from '@angular/core';
import {DriverEmployee} from "../../classes/models/driver-employee";
import {AbstractControl, FormControl, FormGroup, Validators} from "@angular/forms";
import {DriverService} from "../../driver/driver.service";
import * as moment from "moment";
import {Route} from "../../classes/route";
import {RouteService} from "../route.service";
import { forkJoin } from 'rxjs';
import {Vehicle} from "../../classes/vehicle";
import {VehicleService} from "../../vehicle/vehicle.service";
import {Driver} from "../../classes/models/driver";

declare var $: any;

@Component({
  selector: 'app-route-modal',
  templateUrl: './route-modal.component.html',
  styleUrls: ['./route-modal.component.css']
})
export class RouteModalComponent implements OnInit {

  @ViewChild('modal', {static: false}) editModal: ElementRef;
  @Output() editFormSubmitted = new EventEmitter<DriverEmployee>();
  driversList: Driver[];
  vehiclesList: Vehicle[];
  routeForm: FormGroup;
  savingData = false;
  editMode = false;
  currentRoute: Route;
  dataLoaded = false;
  title = '';

  constructor(private routeService: RouteService,
              private driverService: DriverService,
              private vehicleService: VehicleService) { }

  ngOnInit() {
    this.initForm();
  }

  /**
   * initialize the edit classroom form besed on the optional provided classroom or for a new classroom
   */
  initForm(route?: Route) {
    this.dataLoaded = false;
    this.routeForm = new FormGroup({
      id: new FormControl('', Validators.required),
      d_row: new FormControl('', Validators.required),
      v_row: new FormControl('', Validators.required),
      destination: new FormControl('', Validators.required)
    });

    this.getDriverAndVehicleData();


    // if (employee) {
    //   this.currentEmployee = employee;
    //   this.employeeForm.setValue({
    //     name: employee.name,
    //     lastName: employee.lastName,
    //     dtReceived: moment(employee.dtReceived).format('YYYY-MM-DD'),
    //     nationality: employee.nationality,
    //     address: employee.address,
    //     city: employee.city,
    //     dtStarted: moment(employee.dtStarted).format('YYYY-MM-DD'),
    //     dtStopped: moment(employee.dtStopped).format('YYYY-MM-DD')
    //   });
    // } else {
      // this.currentEmployee = new D(0);
    // }
  }

  /**
   * show the bootstrap modal using jQuery code and initialize the edit form
   */
  showModal(route?: Route) {
    $(this.editModal.nativeElement).modal();
    if (route) {
      this.title = 'Edit Route';
      this.editMode = true;
    } else {
      this.title = 'Create new Route';
      this.editMode = false;
    }
    this.initForm(route);
  }

  /**
   * hides the modal and reset the modal component variables
   */
  hideModal() {
    this.currentRoute = null;
    this.savingData = false;
    this.title = '';
    this.editMode = false;
    this.routeForm.reset();
    $(this.editModal.nativeElement).modal('hide');
  }

  formTouchedCondition(control: AbstractControl) {
    return control.invalid && (control.dirty || control.touched);
  }

  isInvalidControlCondition(control: AbstractControl) {
    return control.invalid && this.formTouchedCondition(control);
  }

  onSaveChanges() {

    this.savingData = true;
    this.routeService.postNewRoute({
      d_type: this.driversList[this.routeForm.value.d_row].type,
      d_id: this.driversList[this.routeForm.value.d_row].id,
      v_type: this.vehiclesList[this.routeForm.value.v_row].type,
      v_id: this.vehiclesList[this.routeForm.value.v_row].id,
      destination: this.routeForm.value.destination
    }).subscribe(data => {
      console.log(data);
      this.savingData = false;
      this.editFormSubmitted.emit(data);
      this.hideModal();
    })

    // console.log(this.employeeForm);
    // if (this.editMode) {
    //   this.driverService.updateEmployeeDriver({
    //     id: this.currentEmployee.id,
    //     ...this.employeeForm.value
    //   }).subscribe(data => {
    //     this.editFormSubmitted.emit(data);
    //     this.hideModal();
    //   });
    // } else {
    //   this.driverService.postEmployeeDriver(this.employeeForm.value).subscribe(data => {
    //     this.editFormSubmitted.emit(data);
    //     this.hideModal();
    //   });
    // }
  }

  getDriverAndVehicleData() {
    forkJoin(
      // as of RxJS 6.5+ we can use a dictionary of sources
      {
        vehicles: this.vehicleService.getAllVehicles(),
        drivers: this.driverService.getAllDrivers()
      }
    )
      // { google: object, microsoft: object, users: array }
      .subscribe(data => {
        this.driversList = data.drivers;
        this.vehiclesList = data.vehicles;
        this.dataLoaded = true;
      });
  }
}
