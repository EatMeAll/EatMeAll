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
                        <i className="material-icons">
                            today
                        </i>
                        Obecny tydzień
                    </Button>
                    <Button>
                        <i className="material-icons">
                            calendar_today
                        </i>
                        Kalendarz
                    </Button>
                </div>
            </div>
        )
    }
}

export default MealSchedule;