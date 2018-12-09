import React, {Component} from 'react';

import styles from './Toolbar.css'
import Logo from '../../Logo/Logo';
import NavigationItems from '../NavigationItems/BeforeLogin/NavigationItems';
import NavItems from '../NavigationItems/AfterLogin/NavItems';
import DrawerToggle from '../SideDrawer/DrawerToggle/DrawerToggle';


class Toolbar extends Component {
    state = {
        auth: true
    };

    render() {
        let navigation = <NavigationItems/>;

        if (this.state.auth) {
            navigation = <NavItems/>
        }

        return (
            <header className={styles.Toolbar}>
                <Logo/>
                <nav className={styles.DesktopOnly}>
                    {navigation}
                </nav>
                <DrawerToggle clicked={this.props.drawerToggleClicked}/>
            </header>
        )
    }

}

export default Toolbar;