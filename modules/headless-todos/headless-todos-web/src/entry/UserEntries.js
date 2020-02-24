import React, {useContext, useEffect, useState} from 'react';
import {Loading} from '../components/loading/Loading';
import {Link, withRouter} from 'react-router-dom';



import ListView from '../components/list-view/ListView';

const UserEntries = withRouter(({history, location}) => {

    const [state, setState] = useState({
        dataDefinition: null,
        dataListView: {
            fieldNames: []
        },
        isLoading: false
    });

    const { isLoading } = state;

    const actions = [];

   return (
       <div>

            <Loading isLoading={isLoading}>
                <ListView endpoint={'/o/headless-todos/v1.0/todos'}
                          actions={actions}>
                </ListView>
            </Loading>
        </div>
   );
 });

 export default UserEntries;