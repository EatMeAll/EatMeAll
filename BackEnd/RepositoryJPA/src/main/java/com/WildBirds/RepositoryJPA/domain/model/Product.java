package com.WildBirds.RepositoryJPA.domain.model;

import com.WildBirds.RepositoryJPA.domain.model.baseEntity.BaseEntity;
import com.WildBirds.RepositoryJPA.domain.model.enums.ProductCategorie;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduct;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(nullable = false)
    private String unit;
    private ProductCategorie categorie;

    public Product() {
    }

    public Product(String name, String unit, ProductCategorie categorie) {
        this.name = name;
        this.unit = unit;
        this.categorie = categorie;
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

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                '}';
    }
}
