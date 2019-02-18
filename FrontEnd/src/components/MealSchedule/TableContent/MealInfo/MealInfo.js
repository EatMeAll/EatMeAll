import React, {Component} from 'react';

import styles from './MealInfo.css';
import MealRecipe from "../../../MealRecipe/MealRecipe";
import ListOfMeals from "../../../ListOfMeals/ListOfMeals";


class MealInfo extends Component {
    constructor() {
        super();
        this.state = {
            mealName: "",
            mealId: undefined,
            mealTime: ''
        }
    }

    componentWillReceiveProps(nextProps) {
        if (this.props.meal !== nextProps.meal) {
            this.setState({
                mealName: nextProps.meal["title"],
                mealId: nextProps.meal["idMeal"],
                mealTime: nextProps.meal["mealTime"]
            })
        }
    }

    showDetails = (e) => {
        fetch('http://eatmeall.pl:100/app/meals/' + this.state.mealId)
            .then((response) => response.json())
            .then((myJson) => {
                this.showDetailsPopup(myJson[0]);
            });
    }

    randomizeMeal = (e) => {
        fetch('http://eatmeall.pl:100/app/meals/short/mealTime?mealTime=' + this.state.mealTime + '&language=PL&amount=1')
            .then((response) => response.json())
            .then((myJson) => {
                this.setState({mealName: (myJson[0]["title"]), mealId: (myJson[0]["idMeal"])});
            });
    }

    changeMealFromList = (e) => {
        fetch('http://eatmeall.pl:100/app/meals/short/mealTime?mealTime=' + this.state.mealTime + '&language=PL&amount=10')
            .then((response) => response.json())
            .then((myJson) => {
                this.showMealsListPopup(myJson);
            });
    }

    showDetailsPopup(selectedMealJson) {
        this.props.openModal(
            <MealRecipe
                mealDetails={selectedMealJson}
                typeOfMeal={this.props.mealType}
            />)
    }

    showMealsListPopup(randomMealList) {
        this.props.openModal(
            <ListOfMeals
                mealList={randomMealList}
                setMealCallback={this.setMeal}
                modalClosed={this.props.modalClosed}
            />
        )
    }

    setMeal = (mealName, id) => {
        this.setState({mealName: mealName, mealId: id})
    }


    componentWillUpdate(nextProps, nextState) {
        if(this.state !== nextState) {
            console.log(nextState);
            localStorage.setItem('day', JSON.stringify(nextState.mealName))
        }
    }

    render() {
        return (
            <div className={styles.ChangeDiv}>
                <div className={styles.MealInfo}>
                    <div className={styles.TypeOfMeal}>{this.props.mealType}</div>
                    <div className={styles.MealName}> {this.state.mealName}</div>
                    <div className={styles.HoverButtons}>
                        <button className={styles.Button} onClick={this.showDetails}><i
                            className="fas fa-book"
                            title="przeczytaj przepis"/>
                        </button>
                        <button className={styles.Button} onClick={this.randomizeMeal}><i
                            className="fas fa-retweet"
                            title="wylosuj inną potrawę"/>
                        </button>
                        <button className={styles.Button} onClick={this.changeMealFromList}><i
                            className="fas fa-list-ul"
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