package com.example.TestProject.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Orderr {
    @Id

    private Integer idOrder;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer custId;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product id;

    private LocalDate dateOrder;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_status")
    private Status idStatus;

    public Integer getIdOrder() { return idOrder; }
    public void setIdOrder(Integer idOrder) { this.idOrder = idOrder; }

    public Customer getCustId() { return custId; }
    public void setCustId(Customer custId) { this.custId = custId; }

    public Product getProduct() { return id; }
    public void setProduct(Product product) { this.id = product; }

    public LocalDate getDateOrder() { return dateOrder; }
    public void setDateOrder(LocalDate dateOrder) { this.dateOrder = dateOrder; }

    public Status getIdStatus() { return idStatus; }
    public void setIdStatus(Status idStatus) { this.idStatus = idStatus; }
}

