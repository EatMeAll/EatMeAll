import React, {Component} from 'react';

import styles from './MealInfo.css';

class MealInfo extends Component {
    render () {
        return (
            <div className={styles.MealInfo}>
                <div className={styles.TypeOfMeal}>{this.props.mealType}</div>
                <div> {this.props.dupa12}</div>
            </div>
        )
    }
}

export default MealInfo;