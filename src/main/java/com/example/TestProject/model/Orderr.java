package com.example.TestProject.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Orderr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_order;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer_id;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product id_product;

    private LocalDate date_order;

    @ManyToOne
    @JoinColumn(name = "status_name", referencedColumnName = "status_name")
    private Status status_name;
    // Getters and setters
    public Integer getIdOrder() { return id_order; }
    public void setIdOrder(Integer idOrder) { this.id_order = idOrder; }

    public Customer getCustomer() { return customer_id; }
    public void setCustomer(Customer customer) { this.customer_id = customer; }

    public Product getProduct() { return id_product; }
    public void setProduct(Product product) { this.id_product = product; }

    public LocalDate getDateOrder() { return date_order; }
    public void setDateOrder(LocalDate dateOrder) { this.date_order = dateOrder; }

    public Status getStatus() { return status_name; }
    public void setStatus(Status status) { this.status_name = status; }
}

