package com.example.TestProject.controller;

import com.example.TestProject.model.Status;
import com.example.TestProject.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/statuses")
@CrossOrigin(origins = "http://localhost:4200")
public class StatusController {

    @Autowired
    private StatusRepository statusRepository;

    @GetMapping
    public List<Status> getAllStatuses() {
        return statusRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Status> createStatus(@RequestBody Status status) {

        status.setIdStat(null);
        Status saved = statusRepository.save(status);
        return ResponseEntity.ok(saved);
    }

    /*@PutMapping("/{id}")
    public ResponseEntity<Status> updateStatus(@PathVariable Integer id, @RequestBody Status status) {
        Optional<Status> existingStatus = statusRepository.findById(id);
        if (existingStatus.isPresent()) {
            Status updatedStatus = existingStatus.get();
            updatedStatus.setStatName(status.getStatName());
            updatedStatus.setIsFinal(status.getIsFinal());
            return ResponseEntity.ok(statusRepository.save(updatedStatus));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStatus(@PathVariable Integer id) {
        if (statusRepository.existsById(id)) {
            statusRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/
}