import React, {Component} from 'react';

import styles from './MealSchedule.css';
import TableHeader from './TableHeader/TableHeader';
import WeekDietPlanTable from './TableContent/WeekDietPlanTable';
import MealRecipe from "../MealRecipe/MealRecipe";

class MealSchedule extends Component {
    state = {
        mealsFromApi: [],
    };

    callToApiWeekSchedule = () => {
        fetch('http://eatmeall.pl:100/app/schedule')
            .then((response) => response.json())
            .then((myJson) => {
                this.setState(this.state.mealsFromApi = myJson);
            });
    };

    componentDidMount() {
        if (!localStorage.getItem('mealsFromApi')) {
        } else {
            localStorage.getItem('mealsFromApi') && this.setState(this.state.mealsFromApi = JSON.parse(localStorage.getItem('mealsFromApi'))
            )
        }
    }

    componentWillUpdate(nextProps, nextState) {
        // const lesserObject = nextState.mealsFromApi.map(day => day["meals"].map( meal => new MealInfoData(meal["idMeal"], meal["title"], meal["mealTime"]) ));
        localStorage.setItem('mealsFromApi', JSON.stringify(nextState.mealsFromApi));
    }




    render() {
        return (
            <React.Fragment>
                <div className={styles.Header}>
                    <TableHeader callback={this.callToApiWeekSchedule}/>
                    <WeekDietPlanTable
                        meals={this.state.mealsFromApi}/>
                </div>
            </React.Fragment>
        );
    }
}

export default MealSchedule;