import React from 'react';

import styles from './MealInfo.css';

const mealInfo = () => (
    <div className={styles.MealInfo}>
        <div className={styles.TypeOfMeal}>Breakfast</div>
        <div> Meal Title</div>
    </div>
);

export default mealInfo;