import {useResource} from '@clayui/data-provider';
import React, {useState} from 'react';
import {withRouter, Link} from 'react-router-dom';

import useQuery from '../../hooks/useQuery';
import {confirmDelete, getItem, deleteItem, getURL} from '../../utils/client';
import TableWithPagination from '../table/TableWithPagination';

import TodoManagementBar from '../management-toolbar/search/TodoManagementBar';

import SearchContext, {
	reducer
} from '../management-toolbar/search/SearchContext';

export default withRouter(
    ({
        endpoint,
        history,
        removeItem
    }) => {

    const [state, setState] = useState(() => ({
        error: false,
        loading: false,
        networkStatus: 4
      }));

    const [query, setQuery] = useQuery(history, {
        companyId: Liferay.ThemeDisplay.getCompanyId(),
        groupId: Liferay.ThemeDisplay.getScopeGroupId(),
        keywords: '',
        page: 1,
        pageSize: 20,
        sort: ''
    });

    const dispatch = action => setQuery(reducer(query, action));



    let items = [];
    let totalCount = 0;
    let totalPages = 1;

    const openDetail = ({item}) =>{
        history.push('/entries/'+item.id);
    }

    const loadData = ()=>{


        const {refetch, resource} = useResource({
            fetchDelay: 0,
            fetchOptions: {
                credentials: 'same-origin',
                method: 'GET'
            },
            link: getURL(endpoint),
            onNetworkStatusChange: status =>
                  setState({
                    error: status === 5,
                    loading: status < 4,
                    networkStatus: status
                  }),
            variables: {...query}
        });

        if(resource){
                ({items = [], totalCount, lastPage: totalPages} = resource);
            }
    }

    loadData();

        return (
            <SearchContext.Provider value={[query, dispatch]}>
                <TodoManagementBar />
                <TableWithPagination items={items} openDetail={openDetail} totalCount={totalCount} />
            </SearchContext.Provider>
        );
    }
);