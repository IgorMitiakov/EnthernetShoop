import { Component, OnInit } from '@angular/core';
import { CustomerService, Customer } from '../../service/customer.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-customer-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './customer.html',
})
export class CustomerListComponent implements OnInit {
  customers: Customer[] = [];

  constructor(private CustomerService: CustomerService) {}

  ngOnInit() {
    this.CustomerService.getAll().subscribe((data) => {
      this.customers = data; console.log("testCustom",data);
    });
  }
}