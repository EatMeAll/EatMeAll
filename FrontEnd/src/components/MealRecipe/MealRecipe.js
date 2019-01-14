import React, {Component} from 'react';
import Button from "../UI/Button/Button"


class MealRecipe extends Component {
    componentWillUpdate() {
        console.log("MealRecipeupdate")
    }


    render() {
        return (
            <React.Fragment>
                <h2>Przepis na coś</h2>
                <div>
                    <h4>składniki</h4>
                    <p>składnik 1</p>
                    <p>składnik 2</p>
                    <p>składnik 3</p>
                </div>
                <p><strong>Sposób wykonania</strong></p>
                <p>Zamerdaj</p>
                <Button onClick={this.props.cancelled}>CANCEL</Button>
            </React.Fragment>
        )
    }
}

export default MealRecipe;