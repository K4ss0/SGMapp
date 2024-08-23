package com.StanGreerMillworks.SGMapp.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;


@Entity
public class TakeoffForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long takeoffId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private LocalDateTime createdAt;

    private String formType;//will be used later for adding in doors etc

    @OneToOne(mappedBy = "takeoffForm", cascade = CascadeType.ALL, orphanRemoval = true)
    private GeneralWindowInfo generalWindowInfo;

    @OneToMany(mappedBy = "takeoffForm", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SpecificWindowInfo> specificWindowInfo;

    @OneToOne(mappedBy = "takeoffForm", cascade = CascadeType.ALL, orphanRemoval = true)
    private LaborBreakdown laborbreakdown;

    public Long getTakeoffId() {
        return takeoffId;
    }

    public void setTakeoffId(Long takeoffId) {
        this.takeoffId = takeoffId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public GeneralWindowInfo getGeneralWindowInfo() {
        return generalWindowInfo;
    }

    public void setGeneralWindowInfo(GeneralWindowInfo generalWindowInfo) {
        this.generalWindowInfo = generalWindowInfo;
    }

    public List<SpecificWindowInfo> getSpecificWindowInfo() {
        return specificWindowInfo;
    }

    public void setSpecificWindowInfo(List<SpecificWindowInfo> specificWindowInfo) {
        this.specificWindowInfo = specificWindowInfo;
    }

    public LaborBreakdown getLaborbreakdown() {
        return laborbreakdown;
    }

    public void setLaborbreakdown(LaborBreakdown laborbreakdown) {
        this.laborbreakdown = laborbreakdown;
    }
}


