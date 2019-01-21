import React, {Component} from 'react';
import styles from './ListOfMeals.css';


class ListOfMeals extends Component {
    prepareMealList(mealList) {
        console.log(this.props.mealList)
        return mealList.map(meal => <li>{meal["title"]}</li>)
    }

    render() {
        const {mealList} = this.props;
        return (
            <div className={styles.MealList}>
                <h2>Wybierz posiłek</h2>
                <ul>
                    <li>{this.prepareMealList(mealList)}</li>
                </ul>
            </div>
        )
    }
}

export default ListOfMeals;