import React, {Component} from 'react';
import styles from './ListOfMeals.css';


class ListOfMeals extends Component {
    changeMealName = (e) => {
        console.log(e.target)
        // this.props.mealList.filter(meal => meal["title"] === e.target.title)[0]["id"];
        // this.props.setMealCallback(id, name)
    }

    prepareMealList(mealList) {
        console.log(mealList)
        return mealList.map(meal => <li><button
            className={styles.mealButton}
            onClick={this.changeMealName} id={meal["id"]}>{meal["title"]}</button></li>)
    }

    render() {
        const {mealList} = this.props;
        return (
            <div className={styles.MealList}>
                <h2>Wybierz posiłek</h2>
                <ul className={styles.mealButtons}>
                    {this.prepareMealList(mealList)}
                </ul>
            </div>
        )
    }
}

export default ListOfMeals;