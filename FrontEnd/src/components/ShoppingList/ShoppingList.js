import React, {Component} from 'react';
import CategoryListOfProduct from './CategoryListOfProduct/CategoryListOfProduct'
import * as myConstClass from '../../fileWithConstants';
import styles from './ShoppingList.css';

class ShoppingList extends Component {
    constructor() {
        let mealsFromLocalStorage = JSON.parse(window.localStorage.getItem('mealsFromApi'));
        super();
        this.state = {
            products: {baking: [], dairy: [], drink: [],meat: [],fish: [], fruit: [], vegetable: [], grains: [], spice: [], other: []},
            mealIds: [mealsFromLocalStorage.map(dayOfWeekPlan => dayOfWeekPlan["meals"].map(meal => meal["idMeal"]))]
        }
    }


    componentDidMount() {
        console.log(this.state.mealIds);
        console.log(myConstClass.SHOPPING_LIST_URL + this.state.mealIds);
        fetch(myConstClass.SHOPPING_LIST_URL + this.state.mealIds)
            .then((response) => response.json())
            .then((myJson) => {
                this.setState({products: myJson});
            });
    }

    render() {
        return (
            <div className={styles.About}>
                <h1>Lista zakupów</h1>
                <CategoryListOfProduct category={"Owoce"} productList={this.state.products["fruit"]}/>
                <CategoryListOfProduct category={"Warzywa"} productList={this.state.products["vegetable"]}/>
                <CategoryListOfProduct category={"Pieczywo"} productList={this.state.products["baking"]}/>
                <CategoryListOfProduct category={"Nabiał"} productList={this.state.products["dairy"]}/>
                <CategoryListOfProduct category={"Mięso"} productList={this.state.products["meat"]}/>
                <CategoryListOfProduct category={"Ryby"} productList={this.state.products["fish"]}/>
                <CategoryListOfProduct category={"Napoje"} productList={this.state.products["drink"]}/>
                <CategoryListOfProduct category={"Ziarna"} productList={this.state.products["grains"]}/>
                <CategoryListOfProduct category={"Przyprawy"} productList={this.state.products["spice"]}/>
                <CategoryListOfProduct category={"Inne"} productList={this.state.products["other"]}/>
            </div>
        )
    }


}

export default ShoppingList;