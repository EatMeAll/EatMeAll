package com.WildBirds.ReposiotryJPA.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TypeMeal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTypeMeal;
    private String name;

    public TypeMeal() {
    }

    public Integer getIdTypeMeal() {
        return idTypeMeal;
    }

    public void setIdTypeMeal(Integer idTypeMeal) {
        this.idTypeMeal = idTypeMeal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
