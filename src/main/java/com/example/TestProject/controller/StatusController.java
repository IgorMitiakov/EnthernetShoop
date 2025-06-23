package com.example.TestProject.controller;

import com.example.TestProject.model.Status;
import com.example.TestProject.service.StatusService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/statuses")
public class StatusController {
    private final StatusService service;
    public StatusController(StatusService service) {
        this.service = service;
    }

    @GetMapping
    public List<Status> getAll() {
        return service.findAll();
    }

    @GetMapping("/{statusName}")
    public Status getById(@PathVariable String statusName) {
        return service.findById(statusName);
    }

    @PostMapping
    public Status create(@RequestBody Status status) {
        return service.save(status);
    }

    @PutMapping("/{statusName}")
    public Status update(@PathVariable String statusName, @RequestBody Status updatedStatus) {
        updatedStatus.setStatusName(statusName);
        return service.save(updatedStatus);
    }

    @DeleteMapping("/{statusName}")
    public void delete(@PathVariable String statusName) {
        service.deleteById(statusName);
    }

}
