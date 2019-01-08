import React, {Component} from 'react';

import styles from './MealSchedule.css';
import TableHeader from './TableHeader/TableHeader';
import WeeKDietPlanTable from './TableContent/WeekDietPlanTable';

class MealSchedule extends Component {
    state = {
        mealsFromApi: []
    };

    callToApiBreakfast = () => {
        fetch('http://eatmeall.pl:100/app/schedule')
            .then((response) => response.json())
            .then((myJson) => {
                this.setState(this.state.mealsFromApi=myJson);
                //     {mondayBreakfast: (myJson[0]["meals"].filter(meal => meal["mealTime"] === "BREAKFAST")[0]["title"])});
                // this.setState({mondayLunch: (myJson[0]["meals"].filter(meal => meal["mealTime"] === "LUNCH")[0]["title"])});
                // this.setState({mondayDinner: (myJson[0]["meals"].filter(meal => meal["mealTime"] === "DINNER")[0]["title"])});
                // this.setState({mondaySnack: (myJson[0]["meals"].filter(meal => meal["mealTime"] === "SNACK")[0]["title"])});
                // this.setState({mondaySupper: (myJson[0]["meals"].filter(meal => meal["mealTime"] === "SUPPER")[0]["title"])});
                // this.setState({tuesdayBreakfast: (myJson[0]["meals"].filter(meal => meal["mealTime"] === "LUNCH")[0]["title"])});
                // this.setState({tuesdayLunch: (myJson[0]["meals"].filter(meal => meal["mealTime"] === "LUNCH")[0]["title"])});
                // this.setState({tuesdayDinner: (myJson[0]["meals"].filter(meal => meal["mealTime"] === "DINNER")[0]["title"])});
                // this.setState({tuesdaySnack: (myJson[0]["meals"].filter(meal => meal["mealTime"] === "SNACK")[0]["title"])});
                // this.setState({tuesdaySupper: (myJson[0]["meals"].filter(meal => meal["mealTime"] === "SUPPER")[0]["title"])});

            });
    };

    render() {
        return (
            <div className={styles.Header}>
                <TableHeader callback={this.callToApiBreakfast}/>
                <WeeKDietPlanTable meals={this.state.mealsFromApi}/>
                    {/*// mBreakfast={this.state.mondayBreakfast} mLunch={this.state.mondayLunch}*/}
                    {/*//           tBreakfast={this.state.tuesdayBreakfast} tLunch={this.state.tuesdayLunch}/>*/}
            </div>);
    }
}

export default MealSchedule;