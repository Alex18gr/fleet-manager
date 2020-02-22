import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home/home.component';
import { NavbarComponent } from './home/navbar/navbar.component';
import { DriverComponent } from './driver/driver/driver.component';
import { DriverListComponent } from './driver/driver-list/driver-list.component';
import { DeleteModalComponent } from './shared/delete-modal/delete-modal.component';
import { EditDriverModalComponent } from './shared/edit-driver-modal/edit-driver-modal.component';
import {ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavbarComponent,
    DriverComponent,
    DriverListComponent,
    DeleteModalComponent,
    EditDriverModalComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
