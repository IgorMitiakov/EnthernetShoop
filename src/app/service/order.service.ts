import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Customer {
  custId: number;
  email: string;
  phoneNumber: string;
  custName: string;
}

export interface Product {
  id: number;
  product_name: string;
  category: string;
  price: number;
}

export interface Status {
  statName: string;
  idStat: number;
  isFinal: boolean;
}

export interface Order {
  idOrder: number;
  custId: Customer;
  dateOrder: string;
  product: Product;
  statName: Status;
}

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  private apiUrl = 'http://localhost:8080/api/orders';
  constructor(private http: HttpClient) {}
  getAll(): Observable<Order[]> {
    return this.http.get<Order[]>(this.apiUrl);
  }
}