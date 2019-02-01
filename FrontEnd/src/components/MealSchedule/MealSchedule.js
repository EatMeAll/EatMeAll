import React, {Component} from 'react';

import styles from './MealSchedule.css';
import TableHeader from './TableHeader/TableHeader';
import WeekDietPlanTable from './TableContent/WeekDietPlanTable';
import Modal from "../UI/Modal/Modal";
import MealRecipe from "../MealRecipe/MealRecipe";

class MealSchedule extends Component {
    state = {
        mealsFromApi: [],
        showModal: false,
        modalData: <MealRecipe/>
    };

    callToApiWeekSchedule = () => {
        fetch('http://eatmeall.pl:100/app/schedule')
            .then((response) => response.json())
            .then((myJson) => {
                this.setState(this.state.mealsFromApi = myJson);
                // this.setState({tuesdaySupper: (myJson[0]["meals"].filter(meal => meal["mealTime"] === "SUPPER")[0]["title"])});

            });
    };

    componentDidMount() {
            if (!localStorage.getItem('mealsFromApi')){
                console.log("dupa")
            } else {
                localStorage.getItem('mealsFromApi') && this.setState(this.state.mealsFromApi= JSON.parse(localStorage.getItem('mealsFromApi'))
                )
            }
        }

    componentWillUpdate(nextProps, nextState) {
        localStorage.setItem('mealsFromApi', JSON.stringify(nextState.mealsFromApi))
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
                <div className={styles.Header}>
                    <TableHeader callback={this.callToApiWeekSchedule}/>
                    <WeekDietPlanTable
                        meals={this.state.mealsFromApi}
                        openModal={this.showModal}
                        modalClosed={this.cancelHandler}/>
                </div>
            </React.Fragment>
        );
    }
}

export default MealSchedule;