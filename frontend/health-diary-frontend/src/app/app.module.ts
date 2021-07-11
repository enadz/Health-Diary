import { ChartsModule } from 'angular-bootstrap-md';
import {HttpClientModule} from '@angular/common/http';
import {NgModule} from '@angular/core';
import {ReactiveFormsModule} from '@angular/forms';
import {BrowserModule} from '@angular/platform-browser';
import {SocialAuthService} from 'angularx-social-login';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {provideGoogleAuthConfig} from './provide-google-auth-config';

import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { PatientComponent } from './patient/patient.component';
import { DoctorComponent } from './doctor/doctor.component';
import { LineChartComponent } from './line-chart/line-chart.component';

@NgModule({
  declarations: [
    AppComponent,
    PatientComponent,
    DoctorComponent,
    LineChartComponent,
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    ChartsModule
  ],
  providers: [
    provideGoogleAuthConfig(),
    SocialAuthService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
