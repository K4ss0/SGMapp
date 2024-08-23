package com.StanGreerMillworks.SGMapp.domain;

import jakarta.persistence.*;


@Entity
public class SpecificWindowInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long windowId;

    private int quantity;
    private String size;
    private String windowType;
    private String windowLocation;
    private boolean grids;
    private boolean clear;
    private boolean lowE;
    private boolean tempered;
    private boolean obscured;
    private boolean tinted;
    private boolean argon;

    @ManyToOne
    @JoinColumn(name = "takeoff_id")
    private TakeoffForm takeoffForm;

    public Long getWindowId() {
        return windowId;
    }

    public void setWindowId(Long windowId) {
        this.windowId = windowId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getWindowType() {
        return windowType;
    }

    public void setWindowType(String windowType) {
        this.windowType = windowType;
    }

    public String getWindowLocation() {
        return windowLocation;
    }

    public void setWindowLocation(String windowLocation) {
        this.windowLocation = windowLocation;
    }

    public boolean isGrids() {
        return grids;
    }

    public void setGrids(boolean grids) {
        this.grids = grids;
    }

    public boolean isClear() {
        return clear;
    }

    public void setClear(boolean clear) {
        this.clear = clear;
    }

    public boolean isLowE() {
        return lowE;
    }

    public void setLowE(boolean lowE) {
        this.lowE = lowE;
    }

    public boolean isTempered() {
        return tempered;
    }

    public void setTempered(boolean tempered) {
        this.tempered = tempered;
    }

    public boolean isObscured() {
        return obscured;
    }

    public void setObscured(boolean obscured) {
        this.obscured = obscured;
    }

    public boolean isTinted() {
        return tinted;
    }

    public void setTinted(boolean tinted) {
        this.tinted = tinted;
    }

    public boolean isArgon() {
        return argon;
    }

    public void setArgon(boolean argon) {
        this.argon = argon;
    }

    public TakeoffForm getTakeoffForm() {
        return takeoffForm;
    }

    public void setTakeoffForm(TakeoffForm takeoffForm) {
        this.takeoffForm = takeoffForm;
    }
}


