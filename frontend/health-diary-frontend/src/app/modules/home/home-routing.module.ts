import { AuthGuard } from './../../core/guards/auth.guard';
import { NoAuthGuard } from './../../core/guards/no-auth.guard';
import { PatientPageComponent } from './pages/patient-page/patient-page.component';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { HomeLayoutComponent } from './home-layout/home-layout.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [{
  path: '', component: HomeLayoutComponent,
  children: [
    { path: '', component: HomePageComponent, canActivate:[NoAuthGuard] },
    { path: 'patient', component: PatientPageComponent, canActivate: [AuthGuard] },
  ]
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule { }
