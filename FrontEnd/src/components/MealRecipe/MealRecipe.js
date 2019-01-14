import React, {Component} from 'react';


class MealRecipe extends Component {
    render() {
        return (
            <React.Fragment>
                <h2>Przepis na {this.props.name}</h2>
                <div>
                    <h4>składniki</h4>
                    <p>składnik 1</p>
                    <p>składnik 2</p>
                    <p>składnik 3</p>
                </div>
                <p><strong>Sposób wykonania</strong></p>
                <p>Zamerdaj</p>
            </React.Fragment>
        )
    }
}

export default MealRecipe;