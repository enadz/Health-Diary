import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Variable } from '@angular/compiler/src/render3/r3_ast';
import {RouterModule, Routes} from '@angular/router';
import { GoogleLoginProvider, SocialAuthService as AngularXSocialAuthService, SocialUser } from 'angularx-social-login';

@Component({
  selector: 'app-patient',
  templateUrl: './patient.component.html',
  styleUrls: ['./patient.component.css']
})
export class PatientComponent implements OnInit {

  user:SocialUser;

  constructor(private socialAuth: AngularXSocialAuthService) {
  }

  ngOnInit(): void {
    this.socialAuth.authState.subscribe((user) =>{
      this.user = user;
    })    
  }

    
  signInWithGoogle(): void {
    this.socialAuth
      .signIn(GoogleLoginProvider.PROVIDER_ID)
      .then((res) => {
        console.log(res);
        this.user= res;
      });
  }

  signOut(): void{
    this.socialAuth.signOut();
    console.log("You've been signed out")
  }

}
