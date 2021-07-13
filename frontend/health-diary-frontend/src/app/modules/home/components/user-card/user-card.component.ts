import { SocialUser } from 'angularx-social-login';
import { AuthService } from './../../../../core/authentication/auth.service';
import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-user-card',
  templateUrl: './user-card.component.html',
  styleUrls: ['./user-card.component.css']
})
export class UserCardComponent implements OnInit {

  user : SocialUser;  
  userIsAuthenticated = false;
  private authListenerSubs!: Subscription

  constructor(private authService:AuthService) { }


  ngOnInit(): void {
    this.user = this.authService.getUser();

    if(this.user)
      console.log(this.user)

    this.userIsAuthenticated = this.authService.getIsAuth();
    this.authListenerSubs = this.authService.getAuthStatusListener().subscribe( isAuth => {
      this.userIsAuthenticated = isAuth
      console.log("is auth", this.userIsAuthenticated)
    });
    console.log(this.userIsAuthenticated);
  }

}
