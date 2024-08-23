package com.StanGreerMillworks.SGMapp.domain;

import jakarta.persistence.*;


@Entity
public class LaborBreakdown {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long laborId;

    private int numberOfInstallers;
    private int hoursPerInstaller;
    private int totalHours;
    private String notes;

    @OneToOne
    @JoinColumn(name = "takeoff_id")
    private TakeoffForm takeoffForm;

    public Long getLaborId() {
        return laborId;
    }

    public void setLaborId(Long laborId) {
        this.laborId = laborId;
    }

    public int getNumberOfInstallers() {
        return numberOfInstallers;
    }

    public void setNumberOfInstallers(int numberOfInstallers) {
        this.numberOfInstallers = numberOfInstallers;
    }

    public int getHoursPerInstaller() {
        return hoursPerInstaller;
    }

    public void setHoursPerInstaller(int hoursPerInstaller) {
        this.hoursPerInstaller = hoursPerInstaller;
    }

    public int getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(int totalHours) {
        this.totalHours = totalHours;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public TakeoffForm getTakeoffForm() {
        return takeoffForm;
    }

    public void setTakeoffForm(TakeoffForm takeoffForm) {
        this.takeoffForm = takeoffForm;
    }
}


