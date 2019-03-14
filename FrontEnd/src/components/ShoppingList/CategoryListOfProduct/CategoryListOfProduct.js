import React, {Component} from 'react';
import styles from "./CategoryListOfProduct.css";

class CategoryListOfProduct extends Component {


    render() {
        return (
            <div className={styles.Category}>
                <div className={styles.ProductLabel}>{this.props.category}</div>
                <ul>{this.createList()}</ul>
            </div>

        )
    }

    createList() {
        return this.props.productList.map(prod => <li>{prod["name"]}, {prod["amount"]}{prod["unit"]}</li>)
    }
}

export default CategoryListOfProduct