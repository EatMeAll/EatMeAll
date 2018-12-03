package com.wildBirds.SystemTestsBackEnd.DTO.full_;


import com.wildBirds.SystemTestsBackEnd.DTO.enums.MealTime;

public class TypeMealDTO {

    private Integer idTypeMeal;
    private MealTime mealTime;

    public TypeMealDTO() {
    }

    public MealTime getMealTime() {
        return mealTime;
    }

    public void setMealTime(MealTime mealTime) {
        this.mealTime = mealTime;
    }

    public Integer getIdTypeMeal() {
        return idTypeMeal;
    }

    public void setIdTypeMeal(Integer idTypeMeal) {
        this.idTypeMeal = idTypeMeal;
    }

    @Override
    public String toString() {
        return "TypeMealDTO{" +
                "idTypeMeal=" + idTypeMeal +
                ", mealTime=" + mealTime +
                '}';
    }
}
