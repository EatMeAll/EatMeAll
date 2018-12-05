package com.WildBirds.RepositoryJPA.domain.model.enums;

public enum MealTime {
    BREAKFAST(1),
    LUNCH(2),
    DINNER(3),
    SNACK(4),
    SUPPER(5),
    DESSERT(6);

    private Integer index;

    MealTime(Integer index) {
        this.index = index;
    }

    public Integer getIndex() {
        return index;
    }
}
