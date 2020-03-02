const spritemap = '/o/classic-theme/images/clay/icons.svg';

import {ClayPaginationBarWithBasicItems} from '@clayui/pagination-bar';
import ClayList from '@clayui/list';
import React, {useContext} from 'react';

import {withLoading} from '../loading/Loading';
import {withEmpty} from './EmptyState';
import SearchContext from '../management-toolbar/search/SearchContext';



const TableWithPagination = ({items, openDetail, removeItem, totalCount}) => {

	const [{page, pageSize}, dispatch] = useContext(SearchContext);
	const deltas = [5, 10, 20, 30, 50, 75].map(size => ({label: size}));

    const listRows = items.map((item, key) =>
        <ClayList.Item key={item.id} flex>
            <ClayList.ItemField>{item.id}</ClayList.ItemField>
            <ClayList.ItemField expand>
                <ClayList.ItemTitle>{item.name}</ClayList.ItemTitle>
                <ClayList.ItemText>{item.description}</ClayList.ItemText>
            </ClayList.ItemField>
            <ClayList.ItemField>
                      <ClayList.QuickActionMenu>
                        <ClayList.QuickActionMenu.Item
                          onClick={() => removeItem({item})}
                          spritemap={spritemap}
                          symbol="trash"
                        />

                        <ClayList.QuickActionMenu.Item
                          onClick={()=> openDetail({item})}
                          spritemap={spritemap}
                          symbol="cog"
                        />
                      </ClayList.QuickActionMenu>
                    </ClayList.ItemField>
         </ClayList.Item>
    );


	return (
		<div className="container-fluid container-fluid-max-xl">
            <ClayList>
                <ClayList.Header>Todo List</ClayList.Header>
                {listRows}
            </ClayList>

			{totalCount > 5 && (
				<div className="taglib-search-iterator-page-iterator-bottom">
					<ClayPaginationBarWithBasicItems
						activeDelta={pageSize}
						activePage={page}
						deltas={deltas}
						ellipsisBuffer={3}
						onDeltaChange={pageSize =>
							dispatch({pageSize, type: 'CHANGE_PAGE_SIZE'})
						}
						onPageChange={page =>
							dispatch({page, type: 'CHANGE_PAGE'})
						}
						totalItems={totalCount}
					/>
				</div>
			)}
		</div>
	);
};

export default withLoading(withEmpty(TableWithPagination));