package com.example.TestProject.controller;

import com.example.TestProject.model.Orderr;
import com.example.TestProject.repository.OrderrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderrController {

    @Autowired
    private OrderrRepository orderrRepository;

    @GetMapping
    public List<Orderr> getAllOrders() {
        return orderrRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Orderr> createOrder(@RequestBody Orderr orderr) {
        if (orderr.getIdOrder() == null) {
            return ResponseEntity.badRequest().body(null);
        }
        if (orderrRepository.existsById(orderr.getIdOrder())) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(orderrRepository.save(orderr));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Orderr> updateOrder(@PathVariable Integer id, @RequestBody Orderr updated) {
        Optional<Orderr> existing = orderrRepository.findById(id);
        if (existing.isPresent()) {
            Orderr order = existing.get();
            order.setCustId(updated.getCustId());
            order.setProduct(updated.getProduct());
            order.setDateOrder(updated.getDateOrder());
            order.setIdStatus(updated.getIdStatus());
            return ResponseEntity.ok(orderrRepository.save(order));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Integer id) {
        if (orderrRepository.existsById(id)) {
            orderrRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
