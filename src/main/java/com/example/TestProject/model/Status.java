package com.example.TestProject.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
public class Status {
    @Id
    @Column(name = "status_name")
    @JsonProperty("statName")
    private String statName;


    @Column(name = "id_status")
    @JsonProperty("idStat")
    private Integer idStat;

    @JsonProperty("isFinal")
    private Boolean isFinal;

    public String getStatName() { return statName; }
    public void setStatName(String statName) { this.statName = statName; }

    public Integer getIdStat() { return idStat; }
    public void setIdStat(Integer idStat) { this.idStat = idStat; }

    public Boolean getIsFinal() { return isFinal; }
    public void setIsFinal(Boolean isFinal) { this.isFinal = isFinal; }
}

