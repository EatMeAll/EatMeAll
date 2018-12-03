import React from 'react';

import styles from '../NavigationItems.css';
import NavigationItem from '../NavigationItem/NavigationItem';


const navigationItems = (props) => (
    <ul className={styles.NavigationItems}>
        <NavigationItem link="/about" active>about us</NavigationItem>
        <NavigationItem link="/contact">contact</NavigationItem>
        <NavigationItem link="/login">log in</NavigationItem>
    </ul>
);

export default navigationItems;