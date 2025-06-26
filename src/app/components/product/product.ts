import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Product, ProductService } from '../../service/product.service';

@Component({
  selector: 'app-product-list',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './product.html',
})
export class ProductListComponent {
  products: Product[] = [];
  newProduct: Product = {
    id: 0,
    product_name: '',
    category: '',
    price: 0
  };
  editMode: boolean = false;
  editProduct: Product | null = null;

  constructor(private productService: ProductService) {
    this.loadProducts();
  }

  loadProducts() {
    this.productService.getAll().subscribe(data => this.products = data);
  }

    searchId: number = 0;
    foundProduct: Product | null = null;
    searchProduct() {
      this.productService.getById(this.searchId).subscribe({
        next: (data) => this.foundProduct = data,
        error: () => this.foundProduct = null
      });
    }

  addProduct() {
    this.productService.create(this.newProduct).subscribe(() => {
      this.loadProducts();
      this.newProduct = { id: 0, product_name: '', category: '', price: 0 };
    });
  }

  deleteProduct(id: number) {
    this.productService.delete(id).subscribe(() => this.loadProducts());
  }

  startEdit(product: Product) {
    this.editMode = true;
    this.editProduct = { ...product };
  }

  saveEdit() {
    if (!this.editProduct) return;
    this.productService.update(this.editProduct).subscribe(() => {
      this.loadProducts();
      this.editProduct = null;
      this.editMode = false;
    });
  }
}
