import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Customer, CustomerService } from '../../service/customer.service';

@Component({
  selector: 'app-customer',
  standalone: true,
  imports: [CommonModule, FormsModule], // Добавлен FormsModule для ngModel
  templateUrl: './customer.html'
})
export class CustomerComponent {
  customers: Customer[] = [];
  newCustomer: Customer = {
    custId: 0,
    custName: '',
    email: '',
    phoneNumber: ''
  };
  editMode: boolean = false;
  editCustomer: Customer | null = null;
  newCustomer1: any = { custId: 0, custName: '', email: '', phoneNumber: '' };

  constructor(private customerService: CustomerService) {
    this.loadCustomers();
  }

  loadCustomers() {
    this.customerService.getAll().subscribe(data => this.customers = data);
  }

  addCustomer() {
    this.customerService.create(this.newCustomer).subscribe(() => {
      this.loadCustomers();
      this.newCustomer = { custId: 0, custName: '', email: '', phoneNumber: '' };
    });
  }
  
  searchId: number = 0;
  foundCustomer: Customer | null = null;
  searchCustomer() {
    this.customerService.getById(this.searchId).subscribe({
      next: (data) => this.foundCustomer = data,
      error: () => this.foundCustomer = null
    });
  }

  deleteCustomer(id: number) {
    this.customerService.delete(id).subscribe(() => this.loadCustomers());
  }

  startEdit(customer: Customer) {
    this.editMode = true;
    this.editCustomer = { ...customer };
  }

  saveEdit() {
    if (!this.editCustomer) return;
    this.customerService.update(this.editCustomer).subscribe(() => {
      this.loadCustomers();
      this.editCustomer = null;
      this.editMode = false;
    });
  }
}