import { AuthService } from './../../../../core/authentication/auth.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-google-auth',
  templateUrl: './google-auth.component.html',
  styleUrls: ['./google-auth.component.css']
})
export class GoogleAuthComponent implements OnInit {

  constructor(private authService: AuthService ) { 
  }

  ngOnInit(): void {
  }

  signInWithGoogle(): void {
    this.authService.signInWithGoogle();
  }

}
