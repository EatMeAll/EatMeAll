import React, {Component} from 'react';

import styles from './MealRecipe.css';

class MealRecipe extends Component {

    prepareProductList(mealDetails) {
        return mealDetails["products"].map(product => <li>{product["name"]}, {product["specialUnit"]}</li>)
    }

    prepareInstruction(mealDetails) {
        return mealDetails["receiptDTO"]["steps"].map(step => <li>{step["header"]}, {step["number"]}</li>)
    }

    render() {
        const {mealDetails = {products: [], receiptDTO: {steps: [] }}, typeOfMeal} = this.props;
        return (
            <React.Fragment>
                <h2>{mealDetails["title"]}</h2>
                <div className={styles.ProductAndInfo}>
                    <div className={styles.BasicInfo}>
                        <p>rodzaj dania: {typeOfMeal}</p>
                        <p>czas przygotowania: {mealDetails["receiptDTO"]["prepareTime"]} min</p>
                        <p>ilość kcal: {mealDetails["amountCalories"]}</p>
                        <p>autor przepisu: {mealDetails["authorReceipt"]}</p>
                    </div>
                    <div className={styles.Products}>
                        <h4 className={styles.MealRecipe}>Składniki</h4>
                        <ul>
                            {
                                this.prepareProductList(mealDetails)
                            }
                        </ul>
                    </div>
                </div>
                <div className={styles.Preparation}>
                    <h4>Sposób wykonania</h4>
                    <ol>
                        {
                            this.prepareInstruction(mealDetails)
                        }
                    </ol>
                </div>
            </React.Fragment>
        )
    }
}

export default MealRecipe;