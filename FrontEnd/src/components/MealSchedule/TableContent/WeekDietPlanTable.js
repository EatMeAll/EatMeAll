import React, {Component} from 'react';

import styles from './WeekDietPlanTable.css';
import DayMealsPlan from "./DayMealsPlan/DayMealsPlan";
import moment from "moment";
import {Button} from "reactstrap/dist/reactstrap.es";
import Modal from "../../UI/Modal/Modal";
import MealRecipe from "../../MealRecipe/MealRecipe";

class WeekDietPlanTable extends Component {

    constructor(){
        super();
        this.state={
            showModal: false,
            modalData: <MealRecipe/>
        }
    }

    cancelHandler = () => {
        this.setState({showModal: false});
    };

    showModal = (modalData) => {
        this.setState({showModal: true, modalData: modalData});

    }


    render() {
        return (
            <React.Fragment>
                <Modal show={this.state.showModal} modalClosed={this.cancelHandler}>
                    {this.state.modalData}
                </Modal>
                <div className={styles.Buttons}>
                    <Button
                        className={styles.Button}><i className="fas fa-arrow-left"/></Button>
                    <Button
                        className={styles.Button}><i className="fas fa-arrow-right"/></Button>
                </div>
                <div className={styles.MealPlan}>
                    <React.Fragment>
                        <DayMealsPlan date={moment().weekday(1)} dayNumber={0} dayPlan={this.props.meals[0]} openModal ={this.showModal} modalClosed={this.cancelHandler} callbackToParent={this.props.callbackToParent}/>
                        <DayMealsPlan date={moment().weekday(2)} dayNumber={1} dayPlan={this.props.meals[1]} openModal ={this.showModal} modalClosed={this.cancelHandler} callbackToParent={this.props.callbackToParent}/>
                        <DayMealsPlan date={moment().weekday(3)} dayNumber={2} dayPlan={this.props.meals[2]} openModal ={this.showModal} modalClosed={this.cancelHandler} callbackToParent={this.props.callbackToParent}/>
                        <DayMealsPlan date={moment().weekday(4)} dayNumber={3} dayPlan={this.props.meals[3]} openModal ={this.showModal} modalClosed={this.cancelHandler} callbackToParent={this.props.callbackToParent}/>
                        <DayMealsPlan date={moment().weekday(5)} dayNumber={4} dayPlan={this.props.meals[4]} openModal ={this.showModal} modalClosed={this.cancelHandler} callbackToParent={this.props.callbackToParent}/>
                        <DayMealsPlan date={moment().weekday(6)} dayNumber={5} dayPlan={this.props.meals[5]} openModal ={this.showModal} modalClosed={this.cancelHandler} callbackToParent={this.props.callbackToParent}/>
                        <DayMealsPlan date={moment().weekday(7)} dayNumber={6} dayPlan={this.props.meals[6]} openModal ={this.showModal} modalClosed={this.cancelHandler} callbackToParent={this.props.callbackToParent}/>
                    </React.Fragment>
                </div>
            </React.Fragment>

        );
    }
}

export default WeekDietPlanTable;