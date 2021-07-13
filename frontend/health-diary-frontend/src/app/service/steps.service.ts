import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { IStepsData } from '../classes/IStepsData';

@Injectable({
    providedIn: 'root'
})

export class StepsService {
    constructor(private http: HttpClient) { }

    getData(): Observable<IStepsData[]> {
        return this.http.get<IStepsData[]>(`${environment.api}/profile/steps`)
    }
}