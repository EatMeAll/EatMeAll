import React, {Component} from 'react';
import styles from './ShoppingList.css';

class ShoppingList extends Component {
    constructor() {
        let mealsFromLocalStorage = JSON.parse(window.localStorage.getItem('mealsFromApi'));
        super();
        this.state = {
            mealId: [mealsFromLocalStorage.map(dayOfWeekPlan => dayOfWeekPlan["meals"][0]["idMeal"]),
                mealsFromLocalStorage.map(dayOfWeekPlan => dayOfWeekPlan["meals"][1]["idMeal"]),
                mealsFromLocalStorage.map(dayOfWeekPlan => dayOfWeekPlan["meals"][2]["idMeal"]),
                mealsFromLocalStorage.map(dayOfWeekPlan => dayOfWeekPlan["meals"][3]["idMeal"]),
                mealsFromLocalStorage.map(dayOfWeekPlan => dayOfWeekPlan["meals"][4]["idMeal"])
            ],
        }
        console.log(mealsFromLocalStorage)
        console.log(this.state.mealId)
    }


    componentDidMount() {
        fetch('http://eatmeall.pl:100/app/shoppingList/id/' + this.state.mealId)
            .then((response) => response.json())
            .then((myJson) => {
                this.setState({products: myJson});
            });
    }

    createProductList() {
        if (this.state.products !== undefined) {
            return this.state.products.map(product =>
                <li>{product["name"]}, {product["amount"]}{product["unit"]}</li>)

        }
    }

    render() {
        return (
            <div className={styles.About}>
                <h1>Lista zakupów</h1>
                <ul>{this.createProductList()}</ul>
            </div>)
    }


}

export default ShoppingList;