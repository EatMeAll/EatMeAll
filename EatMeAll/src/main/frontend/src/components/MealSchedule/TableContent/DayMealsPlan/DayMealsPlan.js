import styles from "../WeekDietPlanTable.css";
import DateLabel from "../DateLabel/DateLabel";
import MealInfo from "../WeekDietPlanTable/MealInfo";
import React, {Component} from "react";

class DayMealsPlan extends Component {
    render() {
        return (
            <div className={styles.Day}>
                <DateLabel />
                <MealInfo mealType={"Breakfast"} />
                <MealInfo mealType={"2nd Breakfast"} />
                <MealInfo mealType={"Lunch"} />
                <MealInfo mealType={"Dessert"} />
                <MealInfo mealType={"Dinner"} />
            </div>
        )
    }
}

export default DayMealsPlan;