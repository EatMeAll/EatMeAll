import React, {Component} from 'react';

import styles from './MealSchedule.css';
import TableHeader from './TableHeader/TableHeader';
import WeekDietPlanTable from './TableContent/WeekDietPlanTable';

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

    openCity(e) {
        // Declare all variables
        var i, tabcontent, tablinks;
        console.log("open")


        // Get all elements with class="tabcontent" and hide them
        tabcontent = document.getElementsByClassName("tabcontent");
        for (i = 0; i < tabcontent.length; i++) {
            tabcontent[i].style.display = "none";
        }

        // Get all elements with class="tablinks" and remove the class "active"
        tablinks = document.getElementsByClassName("tablinks");
        for (i = 0; i < tablinks.length; i++) {
            tablinks[i].className = tablinks[i].className.replace(" active", "");
        }

        // Show the current tab, and add an "active" class to the button that opened the tab
        document.getElementById("user1").style.display = "none";
        document.getElementById("user2").style.display = "none";
        document.getElementById(e.currentTarget.value).style.display = "block";
        e.currentTarget.className += " active";
    }


    render() {
        return (
            <React.Fragment>
                <div className={styles.Header}>
                    <TableHeader callback={this.callToApiWeekSchedule}/>
                    <div className={styles.tab}>
                        <button className={styles.tablink} value="user1" onClick={this.openCity}>Diana</button>
                        <button className={styles.tablink} value="user2" onClick={this.openCity}>pSZemcio</button>
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