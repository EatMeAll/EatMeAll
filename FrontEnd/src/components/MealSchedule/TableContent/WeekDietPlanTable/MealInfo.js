import React, { Component } from 'react';

import styles from './MealInfo.css';

class MealInfo extends Component {
    render() {
        let meal = this.props.meal;
        if (meal != null) {
            return (
                <div className={styles.MealInfo}>
                    <div className={styles.TypeOfMeal}>{meal.mealTime}</div>
                    <div> {meal.title}</div>
                </div>
            )
        } else {
            return <></>
        }

    }
}

export default MealInfo;