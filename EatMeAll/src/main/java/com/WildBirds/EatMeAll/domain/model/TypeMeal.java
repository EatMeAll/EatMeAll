package com.WildBirds.EatMeAll.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

public class TypeMeal {
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
