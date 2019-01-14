import React, {Component} from 'react';

import styles from './MealInfo.css';
import MealRecipe from "../../../MealRecipe/MealRecipe";


class MealInfo extends Component {
    constructor() {
        super();
        this.state = {
            mealName: "",
            mealId: undefined,
            mealCalories: "",
            mealAuthor: "",
            mealProducts: "",
            mealType: "",
            mealPrep: ""
        }
    }

    componentWillReceiveProps(nextProps) {
        this.setState({
            mealName: nextProps.meal["title"],
            mealId: nextProps.meal["idMeal"],
        })
    }

    randomizeMeal = (e) => {
        this.setState({mealName: "need to be random"});
    }


    showDetails = (e) => {
        fetch('http://eatmeall.pl:100/app/meals/' + this.state.mealId)
            .then((response) => response.json())
            .then((myJson) => {
                this.showDetailsPopup(myJson[0]);
            });
    }

    showDetailsPopup(myJson) {
        console.log(myJson);
        this.props.openModal(<MealRecipe name={myJson["title"]}/>)
    }

    render() {

        return (
            <div className={styles.ChangeDiv}>
                <div className={styles.MealInfo}>
                    <div className={styles.TypeOfMeal}>{this.props.mealType}</div>
                    <div className={styles.MealName}> {this.state.mealName}</div>
                    <div className={styles.HoverButtons}>
                        <button className={styles.Button} onClick={this.showDetails}><i className="fas fa-book"
                                                                                        title="przeczytaj przepis"/>
                        </button>
                        <button className={styles.Button} onClick={this.randomizeMeal}><i className="fas fa-retweet"
                                                                                          title="wylosuj inną potrawę"/>
                        </button>
                        <button className={styles.Button}><i className="fas fa-list-ul"
                                                             title="wybierz inną potrawę z listy"/></button>
                        <button className={styles.Button}><i className="far fa-copy" title="kopjuj"/></button>
                        <button className={styles.Button}><i className="fas fa-paste" title="wklej"/></button>
                    </div>
                </div>
            </div>
        )
    }
}

export default MealInfo;