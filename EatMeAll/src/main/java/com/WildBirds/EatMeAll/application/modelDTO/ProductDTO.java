package com.WildBirds.EatMeAll.application.modelDTO;

public class ProductDTO {
    private String name;
    private Integer amount;
    private String unit;
    private String specialUnit;

    public ProductDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getSpecialUnit() {
        return specialUnit;
    }

    public void setSpecialUnit(String specialUnit) {
        this.specialUnit = specialUnit;
    }
}
