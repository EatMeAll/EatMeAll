import React from 'react';

import styles from '../NavigationItems.css';
import NavigationItem from '../NavigationItem/NavigationItem';


const navItems = (props) => (
    <ul className={styles.NavigationItems}>
        <NavigationItem link="/home" active>home</NavigationItem>
        <NavigationItem link="/shopping-list">shopping list</NavigationItem>
        <NavigationItem link="/about">about us</NavigationItem>
        <NavigationItem link="/contact">contact</NavigationItem>
        <NavigationItem link="/profile">profil</NavigationItem>
    </ul>
);

export default navItems;