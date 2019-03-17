import React, {Component} from 'react';
import {Route, Switch, Redirect} from 'react-router-dom';

import Layout from './hoc/Layout/Layout';
import styles from './App.css';
import asyncComponent from './hoc/async';
import AboutUs from "./components/AboutUs/About";
import ShoppingList from "./components/ShoppingList/ShoppingList";

const AsyncHome = asyncComponent(() => {
    return import("./components/MealSchedule/MealSchedule");
});

const AsyncCarousel = asyncComponent(() => {
    return import("./components/PicCarousel/PicCarousel");
});

class App extends Component {
    state = {
        auth:true
    };

    render() {
        return (
            <div className={styles.Container}>
                <Layout>
                    <Switch>
                        {this.state.auth ? <Route path="/home" component={AsyncHome}/> : <Route path="/home" component={AsyncCarousel}/>}
                        <Redirect from="/" exact to='/home'/>
                        <Route path="/about" component={AboutUs}/>
                        <Route path="/shopping-list" component={ShoppingList}/>
                        <Route render={() => <h1>Sorry but our devs still working on this page, see You soon! </h1>}/>
                    </Switch>
                </Layout>
            </div>
        );
    }
}

export default App;
