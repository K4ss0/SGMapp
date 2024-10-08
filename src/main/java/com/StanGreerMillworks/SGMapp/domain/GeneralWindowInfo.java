package com.StanGreerMillworks.SGMapp.domain;

import jakarta.persistence.*;

@Entity
public class
GeneralWindowInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long windowInfoId;

    private String brand;
    private String series;
    private String colorExterior;
    private String colorInterior;
    private String frameType;
    private String hardwareFinish;

    @OneToOne
    @JoinColumn(name = "takeoff_id")
    private TakeoffForm takeoffForm;

    public Long getWindowInfoId() {
        return windowInfoId;
    }

    public void setWindowInfoId(Long windowInfoId) {
        this.windowInfoId = windowInfoId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getColorExterior() {
        return colorExterior;
    }

    public void setColorExterior(String colorExterior) {
        this.colorExterior = colorExterior;
    }

    public String getColorInterior() {
        return colorInterior;
    }

    public void setColorInterior(String colorInterior) {
        this.colorInterior = colorInterior;
    }

    public String getFrameType() {
        return frameType;
    }

    public void setFrameType(String frameType) {
        this.frameType = frameType;
    }

    public String getHardwareFinish() {
        return hardwareFinish;
    }

    public void setHardwareFinish(String hardwareFinish) {
        this.hardwareFinish = hardwareFinish;
    }

    public TakeoffForm getTakeoffForm() {
        return takeoffForm;
    }

    public void setTakeoffForm(TakeoffForm takeoffForm) {
        this.takeoffForm = takeoffForm;
    }


}

