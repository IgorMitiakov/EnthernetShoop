package com.example.TestProject.controller;

import com.example.TestProject.model.Status;
import com.example.TestProject.service.StatusService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/statuses")
@CrossOrigin(origins = "http://localhost:4200")
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
    public Status getById(@PathVariable String statName) {
        return service.findById(statName);
    }

    @PostMapping
    public Status create(@RequestBody Status status) {
        return service.save(status);
    }

    @PutMapping("/{statusName}")
    public Status update(@PathVariable String statName, @RequestBody Status updatedStatus) {
        updatedStatus.setStatName(statName);
        return service.save(updatedStatus);
    }

    @DeleteMapping("/{statusName}")
    public void delete(@PathVariable String statName) {
        service.deleteById(statName);
    }

}
