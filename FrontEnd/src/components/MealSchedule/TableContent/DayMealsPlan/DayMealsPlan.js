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
                    <MealInfo mealType={"śniadanie"} meal={""}/>
                    <MealInfo mealType={"drugie śniadanie"} meal={""}/>
                    <MealInfo mealType={"obiad"} meal={this.props.Dinner}/>
                    <MealInfo mealType={"podwieczorek"} meal={this.props.Snack}/>
                    <MealInfo mealType={"kolacja"} meal={this.props.Supper}/>
                </div>
            )
        } else {
            return (
                <div className={styles.Day}>
                    <DateLabel date={this.props.date}/>
                    <MealInfo mealType={"śniadanie"} meal={this.props.dayPlan["meals"].filter(meal => meal["mealTime"]==="BREAKFAST")[0]}/>
                    <MealInfo mealType={"drugie śniadanie"} meal={this.props.dayPlan["meals"].filter(meal => meal["mealTime"]==="LUNCH")[0]}/>
                    <MealInfo mealType={"obiad"} meal={this.props.dayPlan["meals"].filter(meal => meal["mealTime"]==="DINNER")[0]}/>
                    <MealInfo mealType={"podwieczorek"} meal={this.props.dayPlan["meals"].filter(meal => meal["mealTime"]==="SNACK")[0]}/>
                    <MealInfo mealType={"kolacja"} meal={this.props.dayPlan["meals"].filter(meal => meal["mealTime"]==="SUPPER")[0]}/>
                </div>
            )
        }
    }
}

export default DayMealsPlan;