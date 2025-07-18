package com.example.TestProject.service;

import com.example.TestProject.model.Customer;
import com.example.TestProject.model.Status;
import com.example.TestProject.repository.StatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {
    private final StatusRepository repository;
    public StatusService(StatusRepository repository) {
        this.repository = repository;
    }

    public List<Status> findAll() {
        return repository.findAll();
    }

    public Status getById(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    public Status findById(Integer idStat) {
        return repository.findById(idStat).orElse(null);
    }

    public Status save(Status status) {
        return repository.save(status);
    }

    public void deleteById(Integer idStat) {
        repository.deleteById(idStat);
    }

}
