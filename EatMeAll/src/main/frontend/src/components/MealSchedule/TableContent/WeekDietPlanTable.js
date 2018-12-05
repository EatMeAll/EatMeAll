import React, {Component} from 'react';

import styles from './WeekDietPlanTable.css';
import DayMealsPlan from "./DayMealsPlan/DayMealsPlan";
import moment from "moment";

class WeekDietPlanTable extends Component {


    render() {
        return (
            <div className={styles.MealPlan}>
                <React.Fragment>
                    <DayMealsPlan date={moment().weekday(1)}/>
                    <DayMealsPlan date={moment().weekday(2)}/>
                    <DayMealsPlan date={moment().weekday(3)}/>
                    <DayMealsPlan date={moment().weekday(4)}/>
                    <DayMealsPlan date={moment().weekday(5)}/>
                    <DayMealsPlan date={moment().weekday(6)}/>
                    <DayMealsPlan date={moment().weekday(7)}/>
                </React.Fragment>
            </div>

        );
    }
}

export default WeekDietPlanTable;