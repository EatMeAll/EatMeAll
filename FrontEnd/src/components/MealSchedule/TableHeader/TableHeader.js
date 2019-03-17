import React, {Component} from 'react';

import styles from './TableHeader.css'
import Button from '../../UI/Button/Button'

class TableHeader extends Component {
    generateWeeklyMealsHandler = (e) => {
        this.props.callback();
    };


    saveWeekToDatabase() {

    }

    render() {
        return (
            <div className={styles.TableHeader}>
                <div className={styles.Label}>Plan posiłków</div>
                <div className={styles.Buttons}>
                    <Button onClick={this.generateWeeklyMealsHandler}>
                        Wygeneruj posiłki
                    </Button>
                    <Button onClick={this.saveWeekToDatabase}>
                        <i className="far fa-save"></i>
                        Zapisz tydzień
                    </Button>
                    <Button>
                        <i className="far fa-calendar" />
                        Obecny tydzień
                    </Button>
                    <Button>
                        <i className="far fa-calendar-alt" />
                        Kalendarz
                    </Button>
                </div>
            </div>
        )
    }
}

export default TableHeader;