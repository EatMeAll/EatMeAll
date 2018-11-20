import React from 'react';

import styles from './NavigationItems.css';
import NavigationItem from './NavigationItem/NavigationItem';


const navigationItems = (props) => (
    <ul className={styles.NavigationItems}>
        <NavigationItem link="/" active>about us</NavigationItem>
        <NavigationItem link="/">how does it works</NavigationItem>
        <NavigationItem link="/">contact</NavigationItem>
        <NavigationItem link="/">log in</NavigationItem>
    </ul>
);

export default navigationItems;