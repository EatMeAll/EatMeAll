import React, {Component} from 'react';

import styles from './MealSchedule.css';
import TableHeader from './TableHeader/TableHeader';
import TableContent from './TableContent/WeekDietPlanTable';

class MealSchedule extends Component {
    state = {
      mondayBreakfast: null
    };

    callToApi = () => {
        fetch('http://eatmeall.pl:100/app/schedule')
            .then((response) => response.json())
            .then((myJson) => {
                this.setState({mondayBreakfast: (myJson[0]["meals"].filter(meal => meal["mealTime"]==="BREAKFAST")[0])})
            });
    }


    render() {
        return (
            <div className={styles.Header}>
                <TableHeader callback={this.callToApi}/>
                <TableContent/>
            </div>);
    }
}

export default MealSchedule;