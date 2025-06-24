import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Order {
  id_order: number;
  customer_id: number;
  id: number;
  date_order: Date;
  status_name: string;
  
}

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  private apiUrl = 'http://localhost:8080/api/statuses';
  constructor(private http: HttpClient) {}
  getAll(): Observable<Order[]> {
    return this.http.get<Order[]>(this.apiUrl);
  }
}