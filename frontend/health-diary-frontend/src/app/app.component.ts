import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Variable } from '@angular/compiler/src/render3/r3_ast';
import { Component } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import { GoogleLoginProvider, SocialAuthService as AngularXSocialAuthService, SocialUser } from 'angularx-social-login';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'health-diary-frontend';
  user:SocialUser;
  loggedIn: boolean;

  
  constructor(private socialAuth: AngularXSocialAuthService, private http: HttpClient) {
  }

  ngOnInit(): void {
    this.socialAuth.authState.subscribe((user) =>{
      this.user = user;
      this.loggedIn = (user != null);
    })    
  }

  refreshToken(): void {
    this.socialAuth.refreshAuthToken(GoogleLoginProvider.PROVIDER_ID);
  }

}


