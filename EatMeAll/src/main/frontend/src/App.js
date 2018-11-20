import React, {Component} from 'react';

import Layout from './components/Layout/Layout';
import styles from './App.css';


class App extends Component {
    render() {
        return (
            <div className={styles.Container}>
                <Layout>
                </Layout>
            </div>
        );
    }
}

export default App;
