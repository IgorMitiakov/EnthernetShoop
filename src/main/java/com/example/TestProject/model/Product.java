package com.example.TestProject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_product;

    private String product_name;
    private String category;
    private Integer price;
    // Getters and setters
    public Integer getIdProduct() { return id_product; }
    public void setIdProduct(Integer idProduct) { this.id_product = idProduct; }

    public String getProductName() { return product_name; }
    public void setProductName(String productName) { this.product_name = productName; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public Integer getPrice() { return price; }
    public void setPrice(Integer price) { this.price = price; }
}

