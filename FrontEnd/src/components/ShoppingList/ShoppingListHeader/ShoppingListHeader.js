import React, {Component} from 'react';
import styles from './ShoppingListHeader.css'
import Button from "../../UI/Button/Button";

class ShoppingListHeader extends Component {



    render() {
        return (
            <div className={styles.TableHeader}>
                <div className={styles.Label}>Plan posiłków</div>
                <div className={styles.Buttons}>
                    <Button onClick={this.props.generateShoppingListFunction}>
                        Wygeneruj listę zakupów
                    </Button>
                </div>
            </div>
        )
    }


};


export default ShoppingListHeader