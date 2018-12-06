import React, {Component} from 'react';

import styles from './MealSchedule.css';
import TableHeader from './TableHeader/TableHeader';
import TableContent from './TableContent/WeekDietPlanTable';

class MealSchedule extends Component {
    callToApi() {

    }


    render() {
        return (
            <div className={styles.Header}>
                <TableHeader callback={this.callToApi}/>
                <TableContent />
            </div>);
    }
}

export default MealSchedule;