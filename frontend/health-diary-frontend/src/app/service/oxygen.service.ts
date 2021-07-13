import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { IOxygenData } from '../classes/IOxygenData';

@Injectable({
    providedIn: 'root'
})

export class OxygenService {
    constructor(private http: HttpClient) { }

    getData(): Observable<IOxygenData[]> {
        return this.http.get<IOxygenData[]>(`${environment.api}/profile/{id}/oxygen`)
    }
}