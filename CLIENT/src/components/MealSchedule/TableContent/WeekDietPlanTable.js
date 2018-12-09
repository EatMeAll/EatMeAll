import React, {Component} from 'react';

import styles from './WeekDietPlanTable.css';
import DayMealsPlan from "./DayMealsPlan/DayMealsPlan";
import moment from "moment";
import {Button} from "reactstrap/dist/reactstrap.es";

class WeekDietPlanTable extends Component {




    render() {
        return (
            <React.Fragment>
                <div className={styles.Buttons}>
                    <Button
                        className={styles.Button}><i className="fas fa-arrow-left"/></Button>
                    <Button
                        className={styles.Button}><i className="fas fa-arrow-right"/></Button>
                </div>
                <div className={styles.MealPlan}>
                    <React.Fragment>
                        <DayMealsPlan date={moment().weekday(1)} dupa9={this.props.dupa8}/>
                        <DayMealsPlan date={moment().weekday(2)}/>
                        <DayMealsPlan date={moment().weekday(3)}/>
                        <DayMealsPlan date={moment().weekday(4)}/>
                        <DayMealsPlan date={moment().weekday(5)}/>
                        <DayMealsPlan date={moment().weekday(6)}/>
                        <DayMealsPlan date={moment().weekday(7)}/>
                    </React.Fragment>
                </div>
            </React.Fragment>

        );
    }
}

export default WeekDietPlanTable;