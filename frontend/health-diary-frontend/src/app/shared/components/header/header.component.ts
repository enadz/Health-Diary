import { AuthService } from './../../../core/authentication/auth.service';
import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  
  userIsAuthenticated = false;
  private authListenerSubs!: Subscription

  constructor(private authService:AuthService) { }


  ngOnInit(): void {
    this.userIsAuthenticated = this.authService.getIsAuth();
    this.authListenerSubs = this.authService.getAuthStatusListener().subscribe( isAuth => {
      this.userIsAuthenticated = isAuth
      console.log("is auth", this.userIsAuthenticated)
    });
    console.log(this.userIsAuthenticated);
  }

  
  signOut(): void {
    this.authService.signOut();

  }

}
