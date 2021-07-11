import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { PatientData } from '../patient/PatientData';
import { IPatientData } from '../patient/IPatientData';

@Injectable({
    providedIn: 'root'
})

export class PatientService {
    constructor(private http: HttpClient) { }

    public getData(): Observable<IPatientData> {
        return this.http.get<IPatientData>(`${environment.api}/profile`)
    }
}