import { Component, OnInit } from '@angular/core';
import { ProductService, Product } from '../../service/product.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-product-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './product.html',
})
export class ProductListComponent implements OnInit {
  products: Product[] = [];

  constructor(private productService: ProductService) {}

  ngOnInit() {
    this.productService.getAll().subscribe((data) => {
      this.products = data; console.log("test1",data); console.log("test2",this.products);
    });
  }
}
