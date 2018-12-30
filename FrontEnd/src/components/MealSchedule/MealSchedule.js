import React, { Component } from 'react';

import styles from './MealSchedule.css';
import TableHeader from './TableHeader/TableHeader';
import TableContent from './TableContent/WeekDietPlanTable';
import ScheduleDTO from '../../model/ScheduleDTO';

class MealSchedule extends Component {
    state = {
        mondayBreakfast: null,
        schedule: null
    };

    callToApi = () => {
        fetch('http://127.0.0.1:100/app/schedule')
            .then((response) => response.json())
            .then((myJson) => {

                this.setState({
                    schedule: ScheduleDTO.fromRawData(myJson)
                })
                this.setState({ mondayBreakfast: (myJson[0]["meals"].filter(meal => meal["mealTime"] === "BREAKFAST")[0]["title"]) })
            });
    }


    render() {
        return (
            <div className={styles.Header}>
                <TableHeader callback={this.callToApi} />
                <TableContent schedule={this.state.schedule} dupa8={this.state.mondayBreakfast} />
            </div>);
    }
}

export default MealSchedule;