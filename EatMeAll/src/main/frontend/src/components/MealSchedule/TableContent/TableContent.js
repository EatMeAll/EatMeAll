import React from 'react';

import styles from './TableContent.css';
import DateLabel from './DateLabel/DateLabel';
import MealInfo from './MealInfo/MealInfo';

const mealSchedule = () => (
    <div className={styles.MealPlan}>
        <React.Fragment>
            <div className={styles.Day}>
                <DateLabel/>
                <MealInfo />
                <MealInfo />
                <MealInfo />
                <MealInfo />
                <MealInfo />
            </div>
            <div className={styles.Day}>
                <DateLabel/>
                <MealInfo />
                <MealInfo />
                <MealInfo />
                <MealInfo />
                <MealInfo />
            </div>
            <div className={styles.Day}>
                <DateLabel/>
                <MealInfo />
                <MealInfo />
                <MealInfo />
                <MealInfo />
                <MealInfo />
            </div>
            <div className={styles.Day}>
                <DateLabel/>
                <MealInfo />
                <MealInfo />
                <MealInfo />
                <MealInfo />
                <MealInfo />
            </div>
            <div className={styles.Day}>
                <DateLabel/>
                <MealInfo />
                <MealInfo />
                <MealInfo />
                <MealInfo />
                <MealInfo />
            </div>
            <div className={styles.Day}>
                <DateLabel/>
                <MealInfo />
                <MealInfo />
                <MealInfo />
                <MealInfo />
                <MealInfo />
            </div>
            <div className={styles.Day}>
                <DateLabel/>
                <MealInfo />
                <MealInfo />
                <MealInfo />
                <MealInfo />
                <MealInfo />
            </div>

        </React.Fragment>
    </div>

);

export default mealSchedule;