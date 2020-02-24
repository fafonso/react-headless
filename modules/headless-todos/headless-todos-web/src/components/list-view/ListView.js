import {useResource} from '@clayui/data-provider';
import React, {useState} from 'react';
import {withRouter} from 'react-router-dom';

import useQuery from '../../hooks/useQuery';
import {confirmDelete, getItem, getURL} from '../../utils/client';
import TableWithPagination from '../table/TableWithPagination';

import TodoManagementBar  from '../management-toolbar/search/TodoManagementBar';

import SearchContext, {
	reducer
} from '../management-toolbar/search/SearchContext';

export default withRouter(
    ({
        endpoint,
        history,
        actions
    }) => {

    const [query, setQuery] = useQuery(history, {
        keywords: '',
        page: 1,
        pageSize: 20,
        sort: ''
    });

    const dispatch = action => setQuery(reducer(query, action));

    const {refetch, resource} = useResource({
        fetchDelay: 0,
        fetchOptions: {
            credentials: 'same-origin',
            method: 'GET'
        },
        link: getURL(endpoint),
        onNetworkStatusChange: status => setLoading(status < 4),
        variables: {...query}
    });

    let items = [];
    let totalCount = 0;
    let totalPages = 1;

    if(resource){
        ({items = [], totalCount, lastPage: totalPages} = resource);
    }

    const [isLoading, setLoading] = useState(true);

        return (
            <div>
                <SearchContext.Provider value={[query, dispatch]}>
                    <TodoManagementBar />

                    <TableWithPagination items={items} totalCount={totalCount} />
                </SearchContext.Provider>
            </div>
        );
    }
);