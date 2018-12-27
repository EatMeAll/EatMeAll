import styles from "./DayMealsPlan.css";
import DateLabel from "../DateLabel/DateLabel";
import MealInfo from "../WeekDietPlanTable/MealInfo";
import React, { Component } from "react";

class DayMealsPlan extends Component {



    render() {
        let mealsInforList = this.generateMealsInfoList();
        return (
            <div className={styles.Day}>
                <DateLabel date={this.props.date} />
                {mealsInforList}
            </div>
        )
    }

    generateMealsInfoList() {
        let dayDTO = this.props.dayDTO;
        let mealsInforList = []

        if (dayDTO != null) {
            let keyIterator = 0
            for (const meal of dayDTO.meals) {
                mealsInforList.push(<MealInfo key={keyIterator} meal={meal} />)
                keyIterator++;
            }
        }

        return mealsInforList;

    }
}

export default DayMealsPlan;