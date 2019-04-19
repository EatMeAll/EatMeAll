import React, {Component} from 'react';

import styles from './MealSchedule.css';
import TableHeader from './TableHeader/TableHeader';
import WeekDietPlanTable from './TableContent/WeekDietPlanTable';
import NavigationItem from "../Navigation/NavigationItems/NavigationItem/NavigationItem";
import stylesForNav from '../Navigation/NavigationItems/NavigationItems.css'
import MealTimeMapper from "./TableContent/MealInfo/MealTimeMapper";
import GlobalConfigurationSingleton from "../../GlobalConfigurationSingleton";

class MealSchedule extends Component {

    constructor() {
        super();
        this.users = GlobalConfigurationSingleton.getInstance().users;
        this.state = {
            mealsFromApi: [],

        };

    }

    callToApiWeekSchedule = () => {
        fetch('http://eatmeall.pl:100/app/schedule')
            .then((response) => response.json())
            .then((myJson) => {
                this.setState(this.state.mealsFromApi = myJson);
            });
    };

    componentDidMount() {
        this.loadScheduleFromLocalStore(this.props)

    }

    componentWillUpdate(nextProps) {
        if (this.props.match.params.userName !== nextProps.match.params.userName) {
            this.saveScheduleToLocalStore();
            this.loadScheduleFromLocalStore(nextProps);
            this.setState({selectUserCloneFrom: this.users.filter(user => user !== nextProps.match.params.userName)[0]});
        }
    }

    componentWillUnmount() {
        this.saveScheduleToLocalStore();
    }

    changeOneMealInLocalStorage = (aDayNumber, aMeal) => {
        let ls = JSON.parse(localStorage.getItem(this.props.match.params.userName));
        const mapper = new MealTimeMapper();
        const mealTimeNuber = mapper.stringToNumber(aMeal["mealTime"]);
        ls[aDayNumber]['meals'][mealTimeNuber] = aMeal;
        this.setState({mealsFromApi: ls});
        this.saveScheduleToLocalStore()
        // localStorage.setItem(this.props.match.params.userName, JSON.stringify(ls));
    }

    saveScheduleToLocalStore() {
        localStorage.setItem(this.props.match.params.userName, JSON.stringify(this.state.mealsFromApi));
    }

    loadScheduleFromLocalStore(props) {
        const schedule = JSON.parse(localStorage.getItem(props.match.params.userName));
        const toLoad = schedule !== null ? schedule : [];
        this.setState({mealsFromApi: toLoad});
    }

    cloneWholeSchedule = () => {
        console.log("clone from: " + this.props.match.params.userName + " to: " + this.state.selectUserCloneFrom)
    };

    comboOnChangeHandler = (e) => {
        this.setState({selectUserCloneFrom: e.target.value});
    };

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
                        <div>
                            <select onChange={this.comboOnChangeHandler}>
                                {this.users.filter(user => user !== this.props.match.params.userName).map(user => <option value={user}>{user}</option>)}
                            </select>
                            <button onClick={this.cloneWholeSchedule}> CLONE</button>
                        </div>

                    </div>
                    <WeekDietPlanTable
                        meals={this.state.mealsFromApi}
                        callbackToParent={this.changeOneMealInLocalStorage}/>
                </div>
            </React.Fragment>
        );
    }


}

export default MealSchedule;