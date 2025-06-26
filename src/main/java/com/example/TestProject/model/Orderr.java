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

    @ManyToOne
    @JoinColumn(name = "status_name", referencedColumnName = "status_name")
    private Status statName;

    public Integer getIdOrder() { return idOrder; }
    public void setIdOrder(Integer idOrder) { this.idOrder = idOrder; }

    public Customer getCustId() { return custId; }
    public void setCustId(Customer custId) { this.custId = custId; }

    public Product getProduct() { return id; }
    public void setProduct(Product product) { this.id = product; }

    public LocalDate getDateOrder() { return dateOrder; }
    public void setDateOrder(LocalDate dateOrder) { this.dateOrder = dateOrder; }

    public Status getStatName() { return statName; }
    public void setStatName(Status statName) { this.statName = statName; }
}

