import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';

@Injectable({
    providedIn: 'root'
})

export class PatientService {
    
  private oxyDataListener = new Subject<any>();
  private stepsDataListener = new Subject<any>();
  private heartDataListener = new Subject<any>();
  private doctorListListener = new Subject<any>();


  constructor(private http: HttpClient) { }

    getOxyDataListener() {
        return this.oxyDataListener.asObservable();
      }

    getOxygenData(id) {
        this.http.get<any>(`${environment.api}/profile/` + id + `/oxygen`).subscribe(res=>{
          console.log("service", res)
            this.oxyDataListener.next(res)
        })
    }

    getStepsDataListener() {
      return this.stepsDataListener.asObservable();
    }

    getStepsData(id) {
      this.http.get<any>(`${environment.api}/profile/` + id + `/steps`).subscribe(res=>{
        console.log("service", res)
          this.stepsDataListener.next(res)
      })
    }

    getHeartDataListener() {
      return this.heartDataListener.asObservable();
    }

    getHeartData(id) {
      this.http.get<any>(`${environment.api}/profile/` + id + `/heart`).subscribe(res=>{
        console.log("service", res)
          this.heartDataListener.next(res)
      })
    }

    getDoctorListListener() {
      return this.doctorListListener.asObservable();
    }

    getDoctorList(id) {
      this.http.get<any>(`${environment.api}/profile/` + id + `/doctors`).subscribe(res=>{
        console.log("service", res)
          this.doctorListListener.next(res)
      })
    }

}