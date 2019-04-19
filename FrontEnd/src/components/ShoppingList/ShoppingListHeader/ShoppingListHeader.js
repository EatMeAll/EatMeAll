import React, {Component} from 'react';
import styles from './ShoppingListHeader.css'
import Button from "../../UI/Button/Button";

class ShoppingListHeader extends Component {

    constructor() {
        super();
        this.state = {
            days: [
                {id: 0, value: "PON", isChecked: false},
                {id: 1, value: "WT", isChecked: false},
                {id: 2, value: "ŚR", isChecked: false},
                {id: 3, value: "CZW", isChecked: false},
                {id: 4, value: "PT", isChecked: false},
                {id: 5, value: "SOB", isChecked: false},
                {id: 6, value: "ND", isChecked: false}
            ]
        };
        this.handleChange = this.handleChange.bind(this);
    }

    componentDidMount() {
        this.props.notifyParent(this.state.days);
    }

    handleChange(e) {
        const item = e.target.value;
        const isChecked = e.target.checked;

        const {days} = this.state;
        days[item].isChecked = e.target.checked;

        this.setState({
            days
        }, () => {
            this.props.notifyParent(this.state.days)
        });

    };

    render() {
        return (
            <div className={styles.TableHeader}>
                <div className={styles.Label}>Plan posiłków</div>
                <div className={styles.Buttons}>
                    {this.state.days.map(day =>
                        <label key={day.id}>
                            <input key={day.id} type="checkbox"
                                   checked={day.isChecked} value={day.id} onChange={this.handleChange}/>
                            {day.value}
                        </label>
                    )}
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