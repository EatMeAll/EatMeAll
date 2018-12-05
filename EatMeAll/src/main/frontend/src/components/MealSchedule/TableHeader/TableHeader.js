import React, {Component} from 'react';

import styles from './TableHeader.css'
import Button from '../../UI/Button/Button'

class MealSchedule extends Component {
    render() {
        return (
            <div className={styles.TableHeader}>
                <div className={styles.Label}>Plan posiłków</div>
                <div className={styles.Buttons}>
                    <Button>
                        Wygeneruj posiłki
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

export default MealSchedule;