package com.example.TestProject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customer_id;

    private String customer_name;
    private String email;
    private String phone_number;
    public Integer getCustomerId() { return customer_id; }
    public void setCustomerId(Integer customerId) { this.customer_id = customerId; }

    public String getCustomerName() { return customer_name; }
    public void setCustomerName(String customerName) { this.customer_name = customerName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhoneNumber() { return phone_number; }
    public void setPhoneNumber(String phoneNumber) { this.phone_number = phoneNumber; }
}

