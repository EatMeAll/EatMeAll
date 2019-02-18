import React, {Component} from 'react';
import styles from './ShoppingList.css';

class ShoppingList extends Component {
    constructor() {
        let mealsFromLocalStorage = JSON.parse(window.localStorage.getItem('mealsFromApi'));
        super();
        this.state = {
            mealId: [mealsFromLocalStorage.map(dayOfWeekPlan => dayOfWeekPlan["meals"].map(meal => meal["idMeal"]))]
        }
        // console.log(mealsFromLocalStorage)
        // // console.log(this.state.mealId)
        //
        // // czy jestem taka mądra jak mi się wydaje:
        // let array = [];
        // let i;
        // let j;
        // for (i = 0; i < 7; i++) {
        //     for (j = 0; j < 5; j++) {
        //         array += mealsFromLocalStorage[i]["meals"][j]["idMeal"] + ","
        //     }
        // }
        //
        // console.log(array)
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