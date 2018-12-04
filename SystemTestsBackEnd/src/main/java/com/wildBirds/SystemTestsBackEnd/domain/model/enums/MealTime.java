package com.wildBirds.SystemTestsBackEnd.domain.model.enums;

public enum MealTime {
    BREAKFAST(1),
    LUNCH(2),
    DINNER(3),
    SUPPER(4),
    DESSERT(5);

    private Integer index;

    MealTime(Integer index) {
        this.index = index;
    }

    public Integer getIndex() {
        return index;
    }
}
