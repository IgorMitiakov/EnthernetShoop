import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Status {
  idStatus: number; 
  statName: string;
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

  getById(id: number): Observable<Status> {
      return this.http.get<Status>(`${this.apiUrl}/${id}`);
    }

  create(status: Status): Observable<Status> {
    return this.http.post<Status>(this.apiUrl, status);
  }

  update(status: Status): Observable<Status> {
    return this.http.put<Status>(`${this.apiUrl}/${status.idStatus}`, status); 
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}