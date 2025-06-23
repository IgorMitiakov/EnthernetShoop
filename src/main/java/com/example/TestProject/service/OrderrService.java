package com.example.TestProject.service;

import com.example.TestProject.model.Orderr;
import com.example.TestProject.repository.OrderrRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderrService {
    private final OrderrRepository repository;
    public OrderrService(OrderrRepository repository) {
        this.repository = repository;
    }

    public List<Orderr> findAll() {
        return repository.findAll();
    }

    public Orderr findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Orderr save(Orderr order) {
        return repository.save(order);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

}
