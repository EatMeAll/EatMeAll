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
            mealId: nextProps.meal["idMeal"]
        })
    }

    randomizeMeal = (e) => {
        this.setState({mealName: "need to be random"});
    }



    showDetails= (e) => {
        fetch('http://eatmeall.pl:100/app/meals/'+this.state.mealId)
            .then((response) => response.json())
            .then((myJson) => {
                this.showDetailsPopup(myJson[0]);
            });

    }

    showDetailsPopup(myJson) {
        console.log(myJson)
    }

    render() {
        return (
            <div className={styles.ChangeDiv}>
                <div className={styles.MealInfo}>
                    <div className={styles.TypeOfMeal}>{this.props.mealType}</div>
                    <div className={styles.MealName}> {this.state.mealName}</div>
                    <div className={styles.HoverButtons}>
                        <a onClick={this.showDetails}><i className="fas fa-book" title="przeczytaj przepis"></i></a>
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