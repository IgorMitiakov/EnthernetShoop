import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Status {
  idStat: number;
  statName: string;
  isFinal: boolean;
}

@Injectable({
  providedIn: 'root'
})
export class StatusService {
  private apiUrl = 'http://localhost:8080/api/statuses';
  constructor(private http: HttpClient) {}
  getAll(): Observable<Status[]> {
    return this.http.get<Status[]>(this.apiUrl);
  }
}