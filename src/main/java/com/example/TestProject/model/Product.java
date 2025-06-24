package com.example.TestProject.model;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String product_name;
    private String category;
    private Integer price;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getProduct_name() { return product_name; }
    public void setProduct_name(String product_name) { this.product_name = product_name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public Integer getPrice() { return price; }
    public void setPrice(Integer price) { this.price = price; }
}