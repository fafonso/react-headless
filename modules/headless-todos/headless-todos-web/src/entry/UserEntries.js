import React, {useContext, useEffect, useState} from 'react';
import {Loading} from '../components/loading/Loading';
import {Link, withRouter} from 'react-router-dom';
import {confirmDelete, getItem, deleteItem, getURL} from '../utils/client';
import ListView from '../components/list-view/ListView';

const UserEntries = withRouter(({history, location}) => {

    const baseApiURL = '/o/headless-todos/v1.0/todos/';


   return (
        <ListView endpoint={baseApiURL}  />
   );

 });

 export default UserEntries;