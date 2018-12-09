import React from 'react';

import styles from '../NavigationItems.css';
import NavigationItem from '../NavigationItem/NavigationItem';


const navItems = (props) => (
    <ul className={styles.NavigationItems}>
        <NavigationItem link="/home" active>home</NavigationItem>
        <NavigationItem link="/shopping-list">lista zakupów</NavigationItem>
        <NavigationItem link="/about">o nas</NavigationItem>
        <NavigationItem link="/contact">kontakt</NavigationItem>
        <NavigationItem link="/profile">profil</NavigationItem>
    </ul>
);

export default navItems;