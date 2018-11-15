package com.WildBirds.EatMeAll.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

public class Product {
    private Integer idProduct;
    private String name;

    public Product() {
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
