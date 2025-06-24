package com.example.TestProject.controller;

import com.example.TestProject.model.Product;
import com.example.TestProject.service.ProductService;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService service;
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return service.save(product);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Integer id, @RequestBody Product updatedProduct) {
        updatedProduct.setId(id);
        return service.save(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.deleteById(id);
    }

}