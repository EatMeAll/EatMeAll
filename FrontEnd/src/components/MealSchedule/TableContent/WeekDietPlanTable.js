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
                        <DayMealsPlan date={moment().weekday(1)} dayNumber={0} dayPlan={this.props.meals[0]} openModal ={this.props.openModal} modalClosed={this.props.modalClosed}/>
                        <DayMealsPlan date={moment().weekday(2)} dayNumber={1} dayPlan={this.props.meals[1]} openModal ={this.props.openModal} modalClosed={this.props.modalClosed}/>
                        <DayMealsPlan date={moment().weekday(3)} dayNumber={2} dayPlan={this.props.meals[2]} openModal ={this.props.openModal} modalClosed={this.props.modalClosed}/>
                        <DayMealsPlan date={moment().weekday(4)} dayNumber={3} dayPlan={this.props.meals[3]} openModal ={this.props.openModal} modalClosed={this.props.modalClosed}/>
                        <DayMealsPlan date={moment().weekday(5)} dayNumber={4} dayPlan={this.props.meals[4]} openModal ={this.props.openModal} modalClosed={this.props.modalClosed}/>
                        <DayMealsPlan date={moment().weekday(6)} dayNumber={5} dayPlan={this.props.meals[5]} openModal ={this.props.openModal} modalClosed={this.props.modalClosed}/>
                        <DayMealsPlan date={moment().weekday(7)} dayNumber={6} dayPlan={this.props.meals[6]} openModal ={this.props.openModal} modalClosed={this.props.modalClosed}/>
                    </React.Fragment>
                </div>
            </React.Fragment>

        );
    }
}

export default WeekDietPlanTable;