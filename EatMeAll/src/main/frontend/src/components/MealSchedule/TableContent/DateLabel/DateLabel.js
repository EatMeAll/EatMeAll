import styles from "./DateLabel.css";
import React, {Component} from "react";

class DateLabel extends Component {
    render() {
        return (
            <div className={styles.Date}>
                <i className="material-icons">
                    calendar_today
                </i>
                03.12.2018
            </div>
        )
    }
}

export default DateLabel;
