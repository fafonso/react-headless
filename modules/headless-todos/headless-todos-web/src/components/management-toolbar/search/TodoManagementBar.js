const spritemap = '/o/classic-theme/images/clay/icons.svg';

import React, {useContext} from 'react';
import {withRouter, Link} from 'react-router-dom';
import ClayButton, {ClayButtonWithIcon} from '@clayui/button';
import {ClayDropDownWithItems} from '@clayui/drop-down';
import {ClayCheckbox, ClayInput} from '@clayui/form';
import ClayIcon from '@clayui/icon';
import ClayLabel from '@clayui/label';
import ClayManagementToolbar, {
	ClayResultsBar,
} from '@clayui/management-toolbar';
import SearchContext from '../search/SearchContext';

const TodoManagementBar = () => {

    const [{page, pageSize}, dispatch] = useContext(SearchContext);


    const _handleKeyDown = (e) => {

        var value = e.target.value;
        dispatch({keywords: value, type: 'SEARCH'})

//        if (e.key === 'Enter') {
//
//        }
        return false;
    }

    return (
        <div>
            <ClayManagementToolbar>
                 <ClayManagementToolbar.ItemList>
                     <ClayManagementToolbar.Search showMobile={false}>
                          <ClayInput.Group>
                                <ClayInput.GroupItem>
                                    <ClayInput
                                        aria-label="Search"
                                        className="form-control input-group-inset input-group-inset-after"
                                        defaultValue=""
                                        type="text"
                                        onKeyPress={_handleKeyDown}
                                        onChange={_handleKeyDown}
                                        onPaste={_handleKeyDown}
                                        onInput={_handleKeyDown}
                                      />
                                       <ClayInput.GroupInsetItem after tag="span">
                                                      <ClayButtonWithIcon
                                                        className="navbar-breakpoint-d-none"
                                                        displayType="unstyled"
                                                        onClick={() => alert('ff')}
                                                        spritemap={spritemap}
                                                        symbol="times"
                                                      />
                                  <ClayButtonWithIcon displayType="unstyled" spritemap={spritemap} symbol="search" type="submit" />
                                                </ClayInput.GroupInsetItem>
                                </ClayInput.GroupItem>
                          </ClayInput.Group>
                     </ClayManagementToolbar.Search>
                         <ClayManagementToolbar.Item>
                             <Link to='/entries/-1'>
                                   <ClayButtonWithIcon
                                        className="nav-btn nav-btn-monospaced"
                                        spritemap={spritemap}
                                        symbol="plus"
                                    />
                             </Link>
                         </ClayManagementToolbar.Item>
                 </ClayManagementToolbar.ItemList>
            </ClayManagementToolbar>
        </div>
    );
};

export default TodoManagementBar;



