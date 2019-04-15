import React, {Component} from 'react';
import styles from './ShoppingListHeader.css'
import Button from "../../UI/Button/Button";

class ShoppingListHeader extends Component {

    constructor() {
        super();
        this.state = {
            days: [
                {id: 0, value: "PON", isChecked: true},
                {id: 1, value: "WT", isChecked: true},
                {id: 2, value: "ŚR", isChecked: true},
                {id: 3, value: "CZW", isChecked: true},
                {id: 4, value: "PT", isChecked: true},
                {id: 5, value: "SOB", isChecked: true},
                {id: 6, value: "ND", isChecked: true}
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