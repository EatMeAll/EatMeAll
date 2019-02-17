package com.WildBirds.RepositoryJPA.domain.model;

import com.WildBirds.RepositoryJPA.domain.model.baseEntity.BaseEntity;
import com.WildBirds.RepositoryJPA.domain.model.enums.ProductCategory;

import javax.persistence.*;

@Entity
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduct;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(nullable = false)
    private String unit;
    @Enumerated(EnumType.STRING)
    private ProductCategory category;

    public Product() {
    }

    public Product(String name, String unit, ProductCategory category) {
        this.name = name;
        this.unit = unit;
        this.category = category;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory categorie) {
        this.category = categorie;
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

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                '}';
    }
}
