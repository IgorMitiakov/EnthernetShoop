package com.example.TestProject.controller;

import com.example.TestProject.model.Product;

import com.example.TestProject.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        logger.info("Received product for creation: {}", product);
        if (product.getId() == null) {
            return ResponseEntity.badRequest().body(null);
        }
        if (productRepository.existsById(product.getId())) {
            return ResponseEntity.badRequest().body(null);
        }
        Product saved = productRepository.save(product);
        logger.info("Saved product with ID: {}", saved.getId());
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        Optional<Product> existing = productRepository.findById(id);
        if (existing.isPresent()) {
            Product updated = existing.get();
            updated.setProduct_name(product.getProduct_name());
            updated.setCategory(product.getCategory());
            updated.setPrice(product.getPrice());
            return ResponseEntity.ok(productRepository.save(updated));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
