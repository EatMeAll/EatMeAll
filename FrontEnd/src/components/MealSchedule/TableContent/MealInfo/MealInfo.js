import React, {Component} from 'react';

import styles from './MealInfo.css';


class MealInfo extends Component {
    constructor() {
        super();
        this.state = {
            mealName: "",
            mealId: undefined
        }
    }

    componentWillReceiveProps(nextProps) {
        this.setState({
            mealName: nextProps.meal["title"],
            mealId: nextProps.meal["id"]
        })
    }

    randomizeMeal = (e) => {
        this.setState({mealName: "need to be random"});
    }


    render() {
        return (
            <div className={styles.ChangeDiv}>
                <div className={styles.MealInfo}>
                    <div className={styles.TypeOfMeal}>{this.props.mealType}</div>
                    <div className={styles.MealName}> {this.state.mealName}</div>
                    <div className={styles.HoverButtons}>
                        <a><i className="fas fa-book" title="przeczytaj przepis"></i></a>
                        <a onClick={this.randomizeMeal}><i className="fas fa-retweet" title="wylosuj inną potrawę"></i></a>
                        <a><i className="fas fa-list-ul" title="wybierz inną potrawę z listy"></i></a>
                        <a><i className="far fa-copy" title="kopjuj"></i></a>
                        <a><i className="fas fa-paste" title="wklej"></i></a>
                    </div>
                </div>
            </div>
        )
    }
}

export default MealInfo;