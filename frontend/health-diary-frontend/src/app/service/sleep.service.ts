import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { ISleepData } from '../classes/ISleepData';

@Injectable({
    providedIn: 'root'
})

export class SleepService {
    constructor(private http: HttpClient) { }

    getData(): Observable<ISleepData[]> {
        return this.http.get<ISleepData[]>(`${environment.api}/profile/sleep`)
    }
}