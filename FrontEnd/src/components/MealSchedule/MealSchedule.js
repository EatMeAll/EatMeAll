import React, {Component} from 'react';

import styles from './MealSchedule.css';
import TableHeader from './TableHeader/TableHeader';
import WeekDietPlanTable from './TableContent/WeekDietPlanTable';
import * as ReactDOM from "react-dom";

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

    openTab(e) {
        // Show the current tab, and add an "active" class to the button that opened the tab
        document.getElementById("user1").style.display = "none";
        document.getElementById("user2").style.display = "none";
        document.getElementById(e.currentTarget.value).style.display = "block";

        document.getElementById("user1B").className = styles.tablink;
        document.getElementById("user2B").className = styles.tablink;
        e.currentTarget.className = styles.active;
    }


    render() {

        return (
            <React.Fragment>
                <div className={styles.Header}>
                    <TableHeader callback={this.callToApiWeekSchedule}/>
                    <div className={styles.tab}>
                        <button id="user1B" className={styles.tablink} value="user1" onClick={this.openTab}>Diana</button>
                        <button id="user2B" className={styles.tablink} value="user2" onClick={this.openTab}>pSZemcio</button>
                    </div>
                    <div id="user1" className={styles.tabcontent}>
                        <WeekDietPlanTable
                            meals={this.state.mealsFromApi}/>
                    </div>

                    <div id="user2" className={styles.tabcontent}>
                        <WeekDietPlanTable
                            meals={this.state.mealsFromApi}/>
                    </div>
                </div>
            </React.Fragment>
        );
    }
}

export default MealSchedule;