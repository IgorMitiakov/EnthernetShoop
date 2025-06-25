import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Customer {
  custId: number;
  custName: string;
  email: string;
  phoneNumber: string;
}

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private apiUrl = 'http://localhost:8080/api/customers';
  constructor(private http: HttpClient) {}
  getAll(): Observable<Customer[]> {
    return this.http.get<Customer[]>(this.apiUrl);
  }
}