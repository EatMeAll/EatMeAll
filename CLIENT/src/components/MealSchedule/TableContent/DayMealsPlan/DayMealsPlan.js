import styles from "./DayMealsPlan.css";
import DateLabel from "../DateLabel/DateLabel";
import MealInfo from "../WeekDietPlanTable/MealInfo";
import React, {Component} from "react";

class DayMealsPlan extends Component {
    


    render() {
        return (
            <div className={styles.Day}>
                <DateLabel date={this.props.date}/>
                <MealInfo mealType={"śniadanie"} dupa12={this.props.dupa9}/>
                <MealInfo mealType={"drugie śniadanie"} />
                <MealInfo mealType={"obiad"} />
                <MealInfo mealType={"podwieczorek"} />
                <MealInfo mealType={"kolacja"} />
            </div>
        )
    }
}

export default DayMealsPlan;