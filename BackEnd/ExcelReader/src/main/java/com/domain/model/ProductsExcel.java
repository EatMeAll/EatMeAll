package com.domain.model;

public class ProductsExcel {

    private String name;
    private Double amount;
    private String unit;
    private String specialUnit;
    private String categorie;

    public ProductsExcel() {
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
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
        return "ProductsExcel:     " + '\n' +
                "name:        " + name +'\n' +
                "amount:      " + amount + '\n' +
                "unit:        " + unit + '\n' +
                "specialUnit :" + specialUnit + '\n';
    }
}
