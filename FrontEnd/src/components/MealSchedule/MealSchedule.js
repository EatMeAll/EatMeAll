import React, {Component} from 'react';

import styles from './MealSchedule.css';
import TableHeader from './TableHeader/TableHeader';
import WeekDietPlanTable from './TableContent/WeekDietPlanTable';
import Modal from "../UI/Modal/Modal";
import MealRecipe from "../MealRecipe/MealRecipe";
import Button from "../UI/Button/Button";

class MealSchedule extends Component {
    state = {
        mealsFromApi: [],
        showRecipeModal: false,
        modalData: <MealRecipe />
    };

    callToApiWeekSchedule = () => {
        fetch('http://eatmeall.pl:100/app/schedule')
            .then((response) => response.json())
            .then((myJson) => {
                this.setState(this.state.mealsFromApi = myJson);
                // this.setState({tuesdaySupper: (myJson[0]["meals"].filter(meal => meal["mealTime"] === "SUPPER")[0]["title"])});

            });
    };


    cancelHandler = () => {
        this.setState({showRecipeModal: false});
    };


    showRecipe = (modalData) => {
        console.log(modalData)
        this.setState({showRecipeModal: true, modalData: modalData});

    }

    render() {
        return (
            <React.Fragment>
                <Modal show={this.state.showRecipeModal} modalClosed={this.cancelHandler}>
                    {this.state.modalData}
                </Modal>
                <div className={styles.Header}>
                    <TableHeader callback={this.callToApiWeekSchedule}/>
                    <WeekDietPlanTable
                        meals={this.state.mealsFromApi}
                        openModal={this.showRecipe}/>
                </div>
            </React.Fragment>
        );
    }
}

export default MealSchedule;