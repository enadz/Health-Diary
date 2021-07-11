import { PatientService } from './../service/patient.service';
import { Component, OnInit } from '@angular/core';
import * as mdb from 'mdb-ui-kit';
import { Input } from 'mdb-ui-kit';
import {ChartsModule} from 'angular-bootstrap-md';
import {Chart} from 'chart.js';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Variable } from '@angular/compiler/src/render3/r3_ast';
import { RouterModule, Routes } from '@angular/router';
import { GoogleLoginProvider, SocialAuthService as AngularXSocialAuthService, SocialUser } from 'angularx-social-login';
import {PatientData} from '../patient/PatientData';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-patient',
  templateUrl: './patient.component.html',
  styleUrls: ['./patient.component.css']
})
export class PatientComponent implements OnInit {

user: SocialUser;
loggedIn: boolean;


constructor(private socialAuth: AngularXSocialAuthService, private http: HttpClient, private patientService: PatientService) {
}

public patientId = {}
dataForPatient: PatientData = new PatientData();

ngOnInit(): void {
  this.socialAuth.authState.subscribe((user) => {
    this.user = user;
    this.loggedIn = (user != null);
    this.getPData();
  })
}

getPData() {
  this.patientService
    .getData()
    .subscribe((data) => (this.patientId = data));
    console.log("jebem mu mater ako je " + (JSON.stringify(this.dataForPatient.patientId)));
}

signInWithGoogle(): void {
  this.socialAuth
    .signIn(GoogleLoginProvider.PROVIDER_ID)
    .then((res) => {
      console.log(res);
      this.user = res;
    });
}

signOut(): void {
  this.socialAuth.signOut();
  console.log("You've been signed out")
}

}
