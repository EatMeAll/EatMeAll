import styles from "./DateLabel.css";
import React, {Component} from "react";
import Moment from 'react-moment';
import moment from "moment";


class DateLabel extends Component {
    state = {
        date: moment().weekday(1)
    };

    render() {
        return (
            <Moment format="DD.MM.YYYY" className={styles.Date}>
                {this.state.date}
            </Moment>
        )
    }
}

export default DateLabel;
