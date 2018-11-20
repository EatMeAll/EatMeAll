import React from 'react';

import EMAlogo from '../../assets/images/EMAlogo.png';
import styles from './Logo.css';


const logo = (props) => (
    <div className={styles.Logo}>
        <a href="/">
            <img src={EMAlogo} alt="Eat Me All"/>
        </a>
    </div>
);

export default logo;