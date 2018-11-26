import React from 'react';

import styles from './Toolbar.css'
import Logo from '../../Logo/Logo';
import NavigationItems from '../NavigationItems/NavigationItems';
import DrawerToggle from '../SideDrawer/DrawerToggle/DrawerToggle';


const toolbar = (props) => (
    <header className={styles.Toolbar}>
        <Logo />
        <nav className={styles.DesktopOnly}>
            <NavigationItems />
        </nav>
        <DrawerToggle clicked={props.drawerToggleClicked} />
    </header>
);

export default toolbar;