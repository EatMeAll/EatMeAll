import React, {Component} from 'react';

import styles from './MealSchedule.css';
import TableHeader from './TableHeader/TableHeader';
import TableContent from './TableContent/TableContent';

class MealSchedule extends Component {
    render() {
        return (
            <div className={styles.Header}>
                <TableHeader />
                <TableContent />
            </div>);
    }
}

export default MealSchedule;