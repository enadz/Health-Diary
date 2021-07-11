import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DoctorComponent } from './doctor/doctor.component';
import { PatientComponent } from './patient/patient.component';

const routes: Routes = [
  { path: 'patient', component: PatientComponent },
  { path: 'doctor', component: DoctorComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }