package com.wildBirds.SystemTestsBackEnd.DTO.unit_;

public class ProductUnitDTO {

    private String name;
    private Double amount;
    private String unit;
    private String specialUnit;

    public ProductUnitDTO() {
    }

    public ProductUnitDTO(String name, Double amount, String unit, String specialUnit) {
        this.name = name;
        this.amount = amount;
        this.unit = unit;
        this.specialUnit = specialUnit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
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

    @Override
    public String toString() {
        return "ProductUnitDTO{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", unit='" + unit + '\'' +
                ", specialUnit='" + specialUnit + '\'' +
                '}';
    }
}
