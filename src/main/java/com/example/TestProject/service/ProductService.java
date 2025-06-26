package com.example.TestProject.service;

import com.example.TestProject.model.Customer;
import com.example.TestProject.model.Product;
import com.example.TestProject.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Product getById(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    public Product save(Product product) {
        return repository.save(product);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }



}
