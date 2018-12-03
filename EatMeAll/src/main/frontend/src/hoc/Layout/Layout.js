import React, {Component} from 'react';

import styles from './Layout.css';
import Toolbar from '../../components/Navigation/Toolbar/Toolbar';
import SideDrawer from '../../components/Navigation/SideDrawer/SideDrawer';
import MealSchedule from '../../components/MealSchedule/MealSchedule';
import PicCarousel from '../../components/PicCarousel/PicCarousel';


class Layout extends Component {
    state = {
        showSideDrawer: false,
        auth: true
    };

    sideDrawerClosedHandler = () => {
        this.setState({showSideDrawer: false});
    };

    sideDrawerToggleHandler = () => {
        this.setState((prevState) => {
            return {showSideDrawer: !prevState.showSideDrawer};
        });
    };


    render() {
        let main = null;

        if (this.state.auth) {
            main = (
                <MealSchedule/>
            )
        } else {
            main = (
                <PicCarousel/>
            )
        }


        return (
            <React.Fragment>
                <Toolbar drawerToggleClicked={this.sideDrawerToggleHandler}/>
                <SideDrawer
                    open={this.state.showSideDrawer}
                    closed={this.sideDrawerClosedHandler}/>
                <main className={styles.Content}>
                    {main}
                </main>
            </React.Fragment>)
    }
}

export default Layout;