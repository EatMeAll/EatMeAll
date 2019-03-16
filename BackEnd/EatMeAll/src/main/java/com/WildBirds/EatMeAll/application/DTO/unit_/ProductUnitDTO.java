package com.WildBirds.EatMeAll.application.DTO.unit_;

import com.WildBirds.RepositoryJPA.domain.model.enums.ProductCategory;

public class ProductUnitDTO {

    private String name;
    private Double amount;
    private String unit;
    private String specialUnit;
    private ProductCategory category;
    public ProductUnitDTO() {
    }

    public ProductUnitDTO(String name, Double amount, String unit, String specialUnit, ProductCategory category) {
        this.name = name;
        this.amount = amount;
        this.unit = unit;
        this.specialUnit = specialUnit;
        this.category = category;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductUnitDTO that = (ProductUnitDTO) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return unit != null ? unit.equals(that.unit) : that.unit == null;
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
