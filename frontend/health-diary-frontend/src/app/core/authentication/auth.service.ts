import { Injectable } from '@angular/core';
import { GoogleLoginProvider, SocialAuthService as AngularXSocialAuthService, SocialUser } from 'angularx-social-login';
import { HttpClient } from '@angular/common/http';
import { Subject } from 'rxjs';
import { Router } from '@angular/router';


@Injectable({
  providedIn: 'root'
})
export class AuthService {

  user: SocialUser;
  loggedIn: boolean;

  private isAuthenticated = false;
  private userId: string;
  private authStatusListener = new Subject<boolean>();

  constructor(
    private router: Router,
    private socialAuth: AngularXSocialAuthService, 
    private http: HttpClient) {
  }


  getIsAuth() {
    return this.isAuthenticated;
  }

  getUserId() {
    return this.userId;
  }

  getUser() {
    return this.user;
  }

  getAuthStatusListener() {
    return this.authStatusListener.asObservable();
  }

  signInWithGoogle(): void {
    this.socialAuth
      .signIn(GoogleLoginProvider.PROVIDER_ID)
      .then((res) => {
        this.authStatusListener.next(true);
        this.isAuthenticated=true;
        this.user=res;
        this.userId=res.email;
        console.log(res);
        this.router.navigate(['/patient']);
      }).catch(err=>{console.log(err)})
  }

  signOut(): void {
    this.socialAuth.signOut();
    this.isAuthenticated=false;
    this.authStatusListener.next(false);
    this.userId=null;
    this.user=null;
    this.router.navigate(['/']);
    console.log("You've been signed out")
  }

}
