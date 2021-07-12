import { RouterModule } from '@angular/router';
import { SharedModule } from './../../shared/shared.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeRoutingModule } from './home-routing.module';
import { HomeLayoutComponent } from './home-layout/home-layout.component';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { PatientPageComponent } from './pages/patient-page/patient-page.component';
import { UserCardComponent } from './components/user-card/user-card.component';
import { GoogleAuthComponent } from './components/google-auth/google-auth.component';


@NgModule({
  declarations: [HomeLayoutComponent, HomePageComponent, PatientPageComponent, UserCardComponent, GoogleAuthComponent],
  imports: [
    CommonModule,
    HomeRoutingModule,
    SharedModule,
    RouterModule
  ]
})
export class HomeModule { }
