import React, {Component} from 'react';

import styles from './MealSchedule.css';
import TableHeader from './TableHeader/TableHeader';
import WeeKDietPlanTable from './TableContent/WeekDietPlanTable';

class MealSchedule extends Component {
    state = {
        mealsFromApi: []
    };

    callToApiWeekSchedule = () => {
        fetch('http://eatmeall.pl:100/app/schedule')
            .then((response) => response.json())
            .then((myJson) => {
                this.setState(this.state.mealsFromApi=myJson);
                 // this.setState({tuesdaySupper: (myJson[0]["meals"].filter(meal => meal["mealTime"] === "SUPPER")[0]["title"])});

            });
    };

    render() {
        return (
            <div className={styles.Header}>
                <TableHeader callback={this.callToApiWeekSchedule}/>
                <WeeKDietPlanTable meals={this.state.mealsFromApi}/>
                    {/*//           tBreakfast={this.state.tuesdayBreakfast} tLunch={this.state.tuesdayLunch}/>*/}
            </div>);
    }
}

export default MealSchedule;