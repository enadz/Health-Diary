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
  stepsData:any;
  stepsToday:any=0;
  heartData:any;
  avgHeartrateToday:any=0;
  doctorList:any=[];

  private oxyDataListenerSub!: Subscription
  private stepsDataListenerSub!: Subscription
  private heartDataListenerSub!: Subscription
  private doctorListListenerSub!: Subscription

  private userEmail: String;

  constructor( private patientService:PatientService, private authService: AuthService) { }


ngOnInit(): void {
    this.userEmail=this.authService.getUserId();
     if(this.userEmail){

      this.patientService.getOxygenData(this.userEmail);
      this.oxyDataListenerSub = this.patientService.getOxyDataListener().subscribe(res=>{
        let length = res.length;
        this.oxygenData=res[length-1];
        console.log("patient page", res)
      });

      this.patientService.getStepsData(this.userEmail);
      this.stepsDataListenerSub = this.patientService.getStepsDataListener().subscribe(res=>{
        let length = res.length;
        this.stepsData=res;
         console.log("patient page", this.stepsData);  //All steps
         this.stepsToday=res[length-1]; //Most recent steps
         console.log("patient page", this.stepsToday)
        });

      this.patientService.getHeartData(this.userEmail);
      this.stepsDataListenerSub = this.patientService.getHeartDataListener().subscribe(res=>{
        let length = res.length;
        this.heartData=res;
        this.avgHeartrateToday=res[length-1]; //Daily bmp
      });

      this.patientService.getDoctorList(this.userEmail);
      this.doctorListListenerSub = this.patientService.getDoctorListListener().subscribe(res=>{
        this.doctorList=res;  
      });

    }
  }
}