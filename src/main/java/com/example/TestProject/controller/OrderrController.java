package com.example.TestProject.controller;


import com.example.TestProject.model.Orderr;
import com.example.TestProject.service.OrderrService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//w

@RestController
@RequestMapping("/api/orders")
public class OrderrController {
    private final OrderrService service;
    public OrderrController(OrderrService service) {
        this.service = service;
    }

    @GetMapping
    public List<Orderr> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Orderr getById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public Orderr create(@RequestBody Orderr order) {
        return service.save(order);
    }

    @PutMapping("/{id}")
    public Orderr update(@PathVariable Integer id, @RequestBody Orderr updatedOrder) {
        updatedOrder.setIdOrder(id);
        return service.save(updatedOrder);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.deleteById(id);
    }


}
