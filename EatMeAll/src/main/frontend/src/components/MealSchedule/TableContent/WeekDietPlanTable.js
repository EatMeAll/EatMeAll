import React from 'react';

import styles from './WeekDietPlanTable.css';
import DayMealsPlan from "./DayMealsPlan/DayMealsPlan";

const mealSchedule = () => (
    <div className={styles.MealPlan}>
        <React.Fragment>
            <DayMealsPlan/>
            <DayMealsPlan/>
            <DayMealsPlan/>
            <DayMealsPlan/>
            <DayMealsPlan/>
            <DayMealsPlan/>
            <DayMealsPlan/>
        </React.Fragment>
    </div>

);

export default mealSchedule;