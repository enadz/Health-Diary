import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';

@Injectable({
    providedIn: 'root'
})

export class PatientService {
    
  private oxyDataListener = new Subject<any>();

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

    

}