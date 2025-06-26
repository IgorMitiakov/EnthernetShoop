import { Component, OnInit } from '@angular/core';
import { OrderService, Order } from '../../service/order.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-order-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './order.html',
})
export class OrderListComponent implements OnInit {
  orders: Order[] = [];

  constructor(private orderService: OrderService) {}

  ngOnInit() {
    this.orderService.getAll().subscribe((data: Order[]) => {
      this.orders = data;
      console.log("1111", data);
    });
  }
}