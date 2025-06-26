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
  idStatus: number;
  statName: string;
}

export interface Order {
  idOrder: number;
  custId: Customer;
  dateOrder: string;
  product: Product;
  idStatus: Status;
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

  create(order: Order): Observable<Order> {
    return this.http.post<Order>(this.apiUrl, order);
  }

  getById(id: number): Observable<Order> {
      return this.http.get<Order>(`${this.apiUrl}/${id}`);
    }

  update(order: Order): Observable<Order> {
    return this.http.put<Order>(`${this.apiUrl}/${order.idOrder}`, order); 
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}