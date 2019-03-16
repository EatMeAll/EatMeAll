import React, {Component} from 'react';

import styles from './MealInfo.css';
import MealRecipe from "../../../MealRecipe/MealRecipe";
import ListOfMeals from "../../../ListOfMeals/ListOfMeals";
import * as myConstClass from "../../../../fileWithConstants";
import MealTimeMapper from "./MealTimeMapper";


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
            if (nextProps.meal !== undefined) {
                this.setState({
                    mealName: nextProps.meal["title"],
                    mealId: nextProps.meal["idMeal"],
                    mealTime: nextProps.meal["mealTime"]
                })
            }
        }
    }

    showDetails = (e) => {
        fetch(myConstClass.SHOW_DETAIL_URL + this.state.mealId)
            .then((response) => response.json())
            .then((myJson) => {
                this.showDetailsPopup(myJson[0]);
            });
    };

    randomizeMeal = (e) => {
        fetch(myConstClass.RANDOM_MEAL_URL + this.state.mealTime + '&language=PL&amount=1')
            .then((response) => response.json())
            .then((myJson) => {
                const meal = myJson[0]
                this.setState({mealName: (meal["title"]), mealId: (meal["idMeal"])});
                this.updateLocalStorage(meal);
            });
    };

    changeMealFromList = (e) => {
        fetch('http://eatmeall.pl:100/app/meals/short/mealTime?mealTime=' + this.state.mealTime + '&language=PL&amount=10')
            .then((response) => response.json())
            .then((myJson) => {
                this.showMealsListPopup(myJson);
            });
    };

    copyActionHandler = () => {
        localStorage.setItem('currentCopiedMeal', JSON.stringify({idMeal: this.state.mealId, mealTime: this.state.mealTime, title: this.state.mealName }));
    };

    pasteActionHandler = () => {
        const objectToPaste = JSON.parse(localStorage.getItem('currentCopiedMeal'));
        this.setState({
            mealName: objectToPaste["title"],
            mealId: objectToPaste["idMeal"],
            mealTime: objectToPaste["mealTime"]
        });
        this.updateLocalStorage(objectToPaste);
    };

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
    };


    updateLocalStorage(meal) {
        let ls = JSON.parse(localStorage.getItem('mealsFromApi'));
        const mapper = new MealTimeMapper();
        const mealTimeNuber = mapper.stringToNumber(meal["mealTime"]);
        ls[this.props.dayNumber]['meals'][mealTimeNuber] = meal;
        localStorage.setItem('mealsFromApi', JSON.stringify(ls));
    }

    componentWillUpdate(nextProps, nextState) {
        if (this.state !== nextState) {
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
                        <button className={styles.Button} onClick={this.copyActionHandler}><i className="far fa-copy" title="kopiuj"/></button>
                        <button className={styles.Button} onClick={this.pasteActionHandler}><i className="fas fa-paste" title="wklej"/></button>
                    </div>
                </div>
            </div>
        )
    }
}

export default MealInfo;