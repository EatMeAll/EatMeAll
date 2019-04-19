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

    }

    componentWillUnmount() {
        localStorage.setItem(this.props.match.params.userName, JSON.stringify(this.state.mealsFromApi));
    }


    componentDidUpdate(nextProps, nextState) {
        const x = localStorage.getItem(this.props.match.params.userName)
        if(x !== null){
            if(x.length>2){

                this.setState({mealsFromApi: x});
            }
        }
    }



    render() {
        console.log();
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