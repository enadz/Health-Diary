import { AuthService } from './../../../../core/authentication/auth.service';
import { PatientService } from './../../../../core/services/patient.service';
import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-patient-page',
  templateUrl: './patient-page.component.html',
  styleUrls: ['./patient-page.component.css']
})
export class PatientPageComponent implements OnInit {

  oxygenData:any;
  private oxyDataListenerSub!: Subscription
  private userEmail: String;

  constructor( private patientService:PatientService, private authService: AuthService) { }


  ngOnInit(): void {
      this.userEmail=this.authService.getUserId();
      if(this.userEmail){
        this.patientService.getOxygenData(this.userEmail);
        this.oxyDataListenerSub = this.patientService.getOxyDataListener().subscribe(res=>{
          let length = res.length;
          this.oxygenData=res[length-1];
          console.log("patient page", res)});
      }

  }

}
