import React, { Component } from 'react';

import styles from './WeekDietPlanTable.css';
import DayMealsPlan from "./DayMealsPlan/DayMealsPlan";
import moment from "moment";
import { Button } from "reactstrap/dist/reactstrap.es";

class WeekDietPlanTable extends Component {




    render() {

        let days = this.generateDays();
        return (
            <React.Fragment>
                <div className={styles.Buttons}>
                    <Button
                        className={styles.Button}><i className="fas fa-arrow-left" /></Button>
                    <Button
                        className={styles.Button}><i className="fas fa-arrow-right" /></Button>
                </div>
                <div className={styles.MealPlan}>
                    <React.Fragment>
                        {days}
                    </React.Fragment>
                </div>
            </React.Fragment>

        );
    }

    generateDays() {

        let days = [];
        if (this.props.schedule != null) {
            let daylist = this.props.schedule.dayList;

            let keyIndex = 0;
            for (const dayDTO of daylist) {
                days.push(<DayMealsPlan key={keyIndex} dayDTO={dayDTO} />)
                keyIndex++;
            }
        }
        return days;

    }
}

export default WeekDietPlanTable;