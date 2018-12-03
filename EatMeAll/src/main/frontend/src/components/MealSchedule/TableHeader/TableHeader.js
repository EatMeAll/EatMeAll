import React, {Component} from 'react';

import styles from './TableHeader.css'
import Button from '../../UI/Button/Button'

class MealSchedule extends Component {
    render() {
        return (
            <div className={styles.TableHeader}>
                <div className={styles.Label}>Schedule</div>
                <div className={styles.Buttons}>
                    <Button>
                        <i className="material-icons">
                            today
                        </i>
                        Today
                    </Button>
                    <Button>
                        <i className="material-icons">
                            calendar_today
                        </i>
                        Calendar
                    </Button>
                </div>
            </div>
        )
    }
}

export default MealSchedule;