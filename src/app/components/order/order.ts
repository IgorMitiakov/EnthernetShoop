import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Order, OrderService } from '../../service/order.service';
import { Customer, CustomerService } from '../../service/customer.service';
import { Product, ProductService } from '../../service/product.service';
import { Status, StatusService } from '../../service/status.service';

@Component({
  selector: 'app-order',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './order.html',
})
export class OrderComponent {
  orders: Order[] = [];
  customers: Customer[] = [];
  products: Product[] = [];
  statuses: Status[] = [];

  newOrder: Order = {
    idOrder: 0,
    custId: {
      custId: 0,
      email: '',
      phoneNumber: '',
      custName: ''
    },
    product: {
      id: 0,
      product_name: '',
      category: '',
      price: 0
    },
    dateOrder: '',
    idStatus: {
      idStatus: 0,
      statName: ''
    }
  };

  editMode: boolean = false;
  editOrder: Order | null = null;

  constructor(
    private orderService: OrderService,
    private customerService: CustomerService,
    private productService: ProductService,
    private statusService: StatusService
  ) {
    this.loadAll();
  }

  loadAll() {
    this.orderService.getAll().subscribe(data => this.orders = data);
    this.customerService.getAll().subscribe(data => this.customers = data);
    this.productService.getAll().subscribe(data => this.products = data);
    this.statusService.getAll().subscribe(data => this.statuses = data);
  }

  searchId: number = 0;
  foundOrder: Order | null = null;
  searchOrder() {
    this.orderService.getById(this.searchId).subscribe({
      next: (data) => this.foundOrder = data,
      error: () => this.foundOrder = null
    });
  }

  addOrder() {
    this.orderService.create(this.newOrder).subscribe(() => {
      this.loadAll();
      this.newOrder = {
        idOrder: 0,
        custId: {
          custId: 0,
          email: '',
          phoneNumber: '',
          custName: ''
        },
        product: {
          id: 0,
          product_name: '',
          category: '',
          price: 0
        },
        dateOrder: '',
        idStatus: {
          idStatus: 0,
          statName: ''
        }
      };
    });
  }

  deleteOrder(id: number) {
    this.orderService.delete(id).subscribe(() => this.loadAll());
  }

  startEdit(order: Order) {
    this.editMode = true;
    this.editOrder = { ...order };
  }

  saveEdit() {
    if (!this.editOrder) return;
    this.orderService.update(this.editOrder).subscribe(() => {
      this.loadAll();
      this.editOrder = null;
      this.editMode = false;
    });
  }
}