import React, {Component} from 'react';
import styles from './AboutUs.css';

class AboutUs extends Component {
    render() {
        return (
            <div className={styles.About}>
                <h1>Diana, Igor, Paweł - trzech ludzików.</h1>
                <p>Jesteśmy fajni i robimy apkę, żeby dostać wymarzoną pracę :)</p>
            </div>)
    }
}

export default AboutUs;