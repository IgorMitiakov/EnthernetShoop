package com.example.TestProject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
public class Customer {
    @Id
    @Column(name = "customer_id")
    private Integer custId;

    @Column(name = "customer_name")

    private String custName;
    private String email;
    private String phoneNumber;

    public Integer getCustId() { return custId; }
    public void setCustId(Integer custId) { this.custId = custId; }

    public String getCustName() { return custName; }
    public void setCustName(String custName) { this.custName = custName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
}