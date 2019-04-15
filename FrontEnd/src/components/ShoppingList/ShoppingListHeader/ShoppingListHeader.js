import React, {Component} from 'react';
import styles from './ShoppingListHeader.css'
import Button from "../../UI/Button/Button";

class ShoppingListHeader extends Component {



    render() {
        return (
            <div className={styles.TableHeader}>
                <div className={styles.Label}>Plan posiłków</div>
                <div className={styles.Buttons}>
                    <input type="checkbox" value={1}/> PON
                    <input type="checkbox" value={1}/> WT
                    <input type="checkbox" value={1}/> ŚR
                    <input type="checkbox" value={1}/> CZW
                    <input type="checkbox" value={1}/> PT
                    <input type="checkbox" value={1}/> SOB
                    <input type="checkbox" value={1}/> ND
                    <span id="space">  </span>
                    <Button onClick={this.props.generateShoppingListFunction}>
                        Wygeneruj listę zakupów
                    </Button>
                </div>
            </div>
        )
    }


};


export default ShoppingListHeader