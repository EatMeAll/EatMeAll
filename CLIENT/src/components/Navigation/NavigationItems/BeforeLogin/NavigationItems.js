import React from 'react';

import styles from '../NavigationItems.css';
import NavigationItem from '../NavigationItem/NavigationItem';


const navigationItems = (props) => (
    <ul className={styles.NavigationItems}>
        <NavigationItem link="/" active>home</NavigationItem>
        <NavigationItem link="/about">o nas</NavigationItem>
        <NavigationItem link="/contact">kontakt</NavigationItem>
        <NavigationItem link="/login">zaloguj</NavigationItem>
    </ul>
);

export default navigationItems;