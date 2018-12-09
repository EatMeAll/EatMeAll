import styles from "./DateLabel.css";
import React, {Component} from "react";
import Moment from 'react-moment';


class DateLabel extends Component {
    render() {
        return (
            <Moment format="DD.MM.YYYY" className={styles.Date}>
                {this.props.date}
            </Moment>
        )
    }
}

export default DateLabel;
