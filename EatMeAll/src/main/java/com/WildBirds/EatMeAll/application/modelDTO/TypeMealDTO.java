package com.WildBirds.EatMeAll.application.modelDTO;


import com.WildBirds.RepositoryJPA.domain.model.enums.MealTime;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TypeMealDTO that = (TypeMealDTO) o;

        if (idTypeMeal != null ? !idTypeMeal.equals(that.idTypeMeal) : that.idTypeMeal != null) return false;
        return mealTime == that.mealTime;
    }

    @Override
    public int hashCode() {
        int result = idTypeMeal != null ? idTypeMeal.hashCode() : 0;
        result = 31 * result + (mealTime != null ? mealTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TypeMealDTO{" +
                "idTypeMeal=" + idTypeMeal +
                ", mealTime=" + mealTime +
                '}';
    }
}
