package com.example.TestProject.controller;

import com.example.TestProject.model.Product;
import com.example.TestProject.model.Status;
import com.example.TestProject.repository.StatusRepository;
import com.example.TestProject.service.StatusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/statuses")
@CrossOrigin(origins = "http://localhost:4200")
public class StatusController {
    private static final Logger logger = LoggerFactory.getLogger(StatusController.class);

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private StatusService statusService;

    @GetMapping
    public List<Status> getAllStatuses() {
        return statusRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Status> createStatus(@RequestBody Status status) {
        logger.info("Received status for creation: {}", status);
        if (status.getIdStatus() == null) {
            return ResponseEntity.badRequest().body(null);
        }
        if (statusRepository.existsById(status.getIdStatus())) {
            return ResponseEntity.badRequest().body(null);
        }
        Status saved = statusRepository.save(status);
        logger.info("Saved status with ID: {}", saved.getIdStatus());
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Status> updateStatus(@PathVariable Integer id, @RequestBody Status status) {
        Optional<Status> existing = statusRepository.findById(id);
        if (existing.isPresent()) {
            Status updated = existing.get();
            updated.setStatName(status.getStatName());

            return ResponseEntity.ok(statusRepository.save(updated));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Status> getById(@PathVariable Integer id) {
        Status status = statusService.getById(id);
        return ResponseEntity.ok(status);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStatus(@PathVariable Integer id) {
        if (statusRepository.existsById(id)) {
            statusRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}