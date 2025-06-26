package com.example.TestProject.service;

import com.example.TestProject.model.Customer;
import com.example.TestProject.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<Customer> findAll() {
        return repository.findAll();
    }

    public Customer findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Customer getById(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    public Customer save(Customer customer) {
        return repository.save(customer);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
