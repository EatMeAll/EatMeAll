import React, {Component} from 'react';

import styles from './MealSchedule.css';
import TableHeader from './TableHeader/TableHeader';
import WeekDietPlanTable from './TableContent/WeekDietPlanTable';
import NavigationItem from "../Navigation/NavigationItems/NavigationItem/NavigationItem";
import stylesForNav from '../Navigation/NavigationItems/NavigationItems.css'

class MealSchedule extends Component {

    constructor() {
        super();
        this.state = {
            mealsFromApi: [],
            currentState: undefined
        };
        this.users = ['Dianka', 'pSZemcio']
    }

    callToApiWeekSchedule = () => {
        fetch('http://eatmeall.pl:100/app/schedule')
            .then((response) => response.json())
            .then((myJson) => {
                this.setState(this.state.mealsFromApi = myJson);
            });
    };

    componentDidMount() {
        console.log("did mount");
        this.loadScheduleFromLocalStore(this.props)
    }

    componentWillUpdate(nextProps) {
        if (this.props.match.params.userName !== nextProps.match.params.userName) {
            localStorage.setItem(this.props.match.params.userName, JSON.stringify(this.state.mealsFromApi));
            console.log("save: " + this.props.match.params.userName);
            this.loadScheduleFromLocalStore(nextProps);
        }
    }

    loadScheduleFromLocalStore(props) {
        const schedule = JSON.parse(localStorage.getItem(props.match.params.userName));
        const toLoad = schedule !== null ? schedule : [];
        this.setState({mealsFromApi: toLoad});
        console.log("load: " + props.match.params.userName);
    }

    componentWillUnmount() {
        // localStorage.setItem(this.props.match.params.userName, JSON.stringify(this.state.mealsFromApi));
    }

    render() {
        return (
            <React.Fragment>
                {this.state.userName}
                <div className={styles.Header}>
                    <TableHeader callback={this.callToApiWeekSchedule}/>
                    <div className={styles.tab}>
                        <ul className={stylesForNav.NavigationItems}>
                            {this.users.map(user => <NavigationItem
                                link={"./" + user}
                            >{user} </NavigationItem>)}
                        </ul>
                    </div>
                    <WeekDietPlanTable
                        meals={this.state.mealsFromApi}/>
                </div>
            </React.Fragment>
        );
    }
}

export default MealSchedule;