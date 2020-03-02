import React, {useState} from 'react';
import {HashRouter as Router, Route, Switch} from 'react-router-dom';

import ViewEntry from '../entry/ViewEntry';
import Tabs from '../components/tab/Tabs';

const MainLayout = () => {
    return (

        <Router>
             <Switch>
                 <Route component={Tabs} exact path="/" />
                 <Route
                    component={ViewEntry}
                    path="/entries/:id"
                />
             </Switch>
         </Router>
    );
 };

 export default MainLayout;