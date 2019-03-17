package com.WildBirds.EatMeAll.application.DTO.full_;

import com.WildBirds.RepositoryJPA.domain.model.enums.ProductCategory;

public class ProductDTO {

    private Integer idProduct;
    private String name;
    private String unit;
    private ProductCategory category;

    public ProductDTO() {
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
