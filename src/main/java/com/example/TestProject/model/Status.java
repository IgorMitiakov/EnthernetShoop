package com.example.TestProject.model;

import jakarta.persistence.*;

@Entity
public class Status {
    @Id
    @Column(name = "status_name")
    private String status_name;


    private Integer id_status;

    private Boolean isFinal;
    // Getters and setters
    public String getStatusName() { return status_name; }
    public void setStatusName(String statusName) { this.status_name = statusName; }

    public Integer getIdStatus() { return id_status; }
    public void setIdStatus(Integer idStatus) { this.id_status = idStatus; }

    public Boolean getIsFinal() { return isFinal; }
    public void setIsFinal(Boolean isFinal) { this.isFinal = isFinal; }
}

