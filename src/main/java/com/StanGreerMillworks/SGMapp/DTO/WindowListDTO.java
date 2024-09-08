package com.StanGreerMillworks.SGMapp.DTO;

public class WindowListDTO {
    private String brand;
    private String series;
    private String colorInterior;
    private String colorExterior;
//if needed add more generalInfo fields here
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
    //if needed add more specificInfo fields here


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
}
