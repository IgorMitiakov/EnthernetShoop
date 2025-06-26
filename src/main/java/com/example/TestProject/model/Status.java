package com.example.TestProject.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
public class Status {
    @Id
    @Column(name = "id_status")
    private Integer idStatus;



    @Column(name = "status_name")
    private String statName;


    public Integer getIdStatus() { return idStatus; }
    public void setIdStatus(Integer idStatus) { this.idStatus = idStatus; }
    public String getStatName() { return statName; }
    public void setStatName(String statName) { this.statName = statName; }

}

