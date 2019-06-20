import React, {Component} from 'react';
import CategoryListOfProduct from './CategoryListOfProduct/CategoryListOfProduct'
import * as myConstClass from '../../restApiUrlsConstants';
import styles from './ShoppingList.css';
import ShoppingListHeader from "./ShoppingListHeader/ShoppingListHeader";
import GlobalConfigurationSingleton from "../../GlobalConfigurationSingleton";

class ShoppingList extends Component {
    constructor() {
        super();
        this.state = {
            products: {
                baking: [],
                dairy: [],
                drink: [],
                meat: [],
                fish: [],
                fruit: [],
                vegetable: [],
                grains: [],
                spice: [],
                other: []
            },
        }
        this.selectedDays = [];
        this.setDays = this.setDays.bind(this);
    }

    setDays(aSelectedDays) {
        if (aSelectedDays !== undefined) {
            this.selectedDays = [];
            aSelectedDays.forEach(day => {
                if (day.isChecked) {
                    this.selectedDays.push(day.id)
                }
            });
        }
    };


    generateShoppingList = () => {
        const selectedDays = [];
        for (const userName of GlobalConfigurationSingleton.getInstance().users) {
            let mealsFromLocalStorage = JSON.parse(window.localStorage.getItem(userName));
            this.selectedDays.forEach(dayId =>{
                selectedDays.push(mealsFromLocalStorage[dayId]);
            });
        }
        this.setState({mealIds: selectedDays.map(dayOfWeekPlan => dayOfWeekPlan["meals"].map(meal => meal["idMeal"]))},
            () => {
                fetch(myConstClass.SHOPPING_LIST_URL + this.state.mealIds)
                    .then((response) => response.json())
                    .then((myJson) => {
                        this.setState({products: myJson});
                    });
            }
        );
    };

    render() {
        return (
            <div>
                <div>
                    <ShoppingListHeader generateShoppingListFunction={this.generateShoppingList}
                                        notifyParent={this.setDays}>
                    </ShoppingListHeader>
                </div>
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
            </div>
        )
    }
}

export default ShoppingList;