import styles from "./DayMealsPlan.css";
import DateLabel from "../DateLabel/DateLabel";
import MealInfo from "../MealInfo/MealInfo";
import React, {Component} from "react";

class DayMealsPlan extends Component {


    render() {
        if (this.props.dayPlan === undefined) {
            return (
                <div className={styles.Day}>
                    <DateLabel date={this.props.date}/>
                    <MealInfo mealType={"śniadanie"} mealName={""}/>
                    <MealInfo mealType={"drugie śniadanie"} mealName={""}/>
                    <MealInfo mealType={"obiad"} mealName={this.props.Dinner}/>
                    <MealInfo mealType={"podwieczorek"} mealName={this.props.Snack}/>
                    <MealInfo mealType={"kolacja"} mealName={this.props.Supper}/>
                </div>
            )
        } else {
            return (
                <div className={styles.Day}>
                    <DateLabel date={this.props.date}/>
                    <MealInfo mealType={"śniadanie"} mealName={this.props.dayPlan["meals"].filter(meal => meal["mealTime"]==="BREAKFAST")[0]["title"]}/>
                    <MealInfo mealType={"drugie śniadanie"} mealName={this.props.Lunch}/>
                    <MealInfo mealType={"obiad"} mealName={this.props.Dinner}/>
                    <MealInfo mealType={"podwieczorek"} mealName={this.props.Snack}/>
                    <MealInfo mealType={"kolacja"} mealName={this.props.Supper}/>
                </div>
            )
        }
    }
}

export default DayMealsPlan;