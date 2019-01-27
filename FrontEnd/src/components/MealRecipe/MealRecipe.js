import React, {Component} from 'react';

import styles from './MealRecipe.css';

class MealRecipe extends Component {

    prepareProductList(mealDetails) {
        return mealDetails["products"].map(product => <li>{product["name"]}, {product["specialUnit"]}</li>)
    }

    render() {
        const {mealDetails = {products: [], receiptDTO: {}}, typeOfMeal} = this.props;
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
                        <li>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Iure, perferendis.</li>
                        <li>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Architecto aut autem culpa cumque
                            doloribus, exercitationem molestias numquam reiciendis repellat vel.
                        </li>
                        <li>Lorem ipsum dolor sit amet, consectetur adipisicing.</li>
                        <li>Lorem ipsum dolor sit amet, consectetur adipisicing elit. At commodi ipsum quae temporibus
                            tenetur totam ut!
                        </li>
                    </ol>
                </div>
            </React.Fragment>
        )
    }
}

export default MealRecipe;