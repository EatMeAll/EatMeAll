import React, {Component} from 'react';

import styles from './MealRecipe.css';

class MealRecipe extends Component {
    render() {
        return (
            <React.Fragment>
                <h2>{this.props.recipeTitle}</h2>
                <div className={styles.ProductAndInfo}>
                    <div className={styles.BasicInfo}>
                        <p>rodzaj dania: {this.props.typeOfMeal}</p>
                        <p>czas przygotowania: {this.props.prepTime}min</p>
                        <p>autor przepisu: {this.props.author}</p>
                    </div>
                    <div className={styles.Products}>
                        <h4 className={styles.MealRecipe}>Składniki</h4>
                        <ul>
                            <li>składnik 1</li>
                            <li>składnik 2</li>
                            <li>składnik 3</li>
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