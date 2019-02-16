package com.WildBirds.EatMeAll.application.DTO.full_;

import com.WildBirds.RepositoryJPA.domain.model.enums.ProductCategorie;

public class ProductDTO {

    private Integer idProduct;
    private String name;
    private String unit;
    private ProductCategorie categorie;

    public ProductDTO() {
    }

    public ProductCategorie getCategorie() {
        return categorie;
    }

    public void setCategorie(ProductCategorie categorie) {
        this.categorie = categorie;
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
