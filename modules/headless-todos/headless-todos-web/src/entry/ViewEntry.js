const spritemap = '/o/classic-theme/images/clay/icons.svg';

import React, {useContext, useEffect, useState, useRef} from 'react';

import ClayForm, {ClayInput} from '@clayui/form';
import ClayButton from '@clayui/button';
import {useResource} from '@clayui/data-provider';
import {confirmDelete, getItem, addItem, deleteItem, getURL} from '../utils/client';
import ClayAlert from '@clayui/alert';
import {Link, withRouter} from 'react-router-dom';

const ViewEntry =  withRouter(({history, location, match}) =>  {

    const nameInputRef = useRef();
    const descriptionInputRef = useRef();

    const [state, setState] = useState(() => ({
            error: false,
            loading: false,
            networkStatus: 4
          }));

    const [toastItems, setToastItems] = useState([]);

    const id = match.params.id;
    const endpoint = '/o/headless-todos/v1.0/todos/' + id;


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
                  })
        });

    const removeItem = () =>{
       deleteItem(endpoint).then((savedVal) => {
            history.push("/");
       });
    }

    if(resource){
        nameInputRef.current.value = resource.name;
        descriptionInputRef.current.value = resource.description;
    }




    const handleSubmit = (event) => {

        event.preventDefault();

        const name = nameInputRef.current.value;
        const description = descriptionInputRef.current.value;

        onSubmit( { id , name, description} );

        return false;
    };


    const onSubmit = ( { id, name, description } ) => {
        const addURL = '/o/headless-todos/v1.0/todos';

        addItem(addURL, {
                creator: null,
                description: description,
                id: id,
                name: name,
                companyId: Liferay.ThemeDisplay.getCompanyId(),
                groupId: Liferay.ThemeDisplay.getScopeGroupId(),
                priority: null
            }
        ).then((savedVal) => {
            match.params.id = savedVal.id;
            nameInputRef.current.value = savedVal.name;
            descriptionInputRef.current.value = savedVal.description;
            setToastItems([...toastItems, Math.random() * 100]);
        });

    };

	return (
        <div>
          <h1>Todo Detail</h1>
            <ClayForm onSubmit={handleSubmit}>
              <ClayForm.Group className="has-success">
                <label htmlFor="basicInput">Name</label>
                <ClayInput placeholder="Name" type="text" ref={nameInputRef} />
              </ClayForm.Group>
              <ClayForm.Group className="has-warning">
                <label htmlFor="basicInput">Description</label>
                <textarea className="form-control" placeholder="Description" ref={descriptionInputRef}  />
              </ClayForm.Group>
              <ClayButton.Group>
                <ClayButton displayType="primary" type="submit">Save</ClayButton>
                <ClayButton displayType="secondary" type="button" onClick={history.goBack}>Cancel</ClayButton>
                <ClayButton displayType="secondary" type="button" onClick={removeItem}>Delete</ClayButton>
              </ClayButton.Group>
            </ClayForm>
        <ClayAlert.ToastContainer>
        {toastItems.map(value => (
          <ClayAlert
            displayType='success'
            autoClose={5000}
            key={value}
            onClose={() => {
              setToastItems(prevItems =>
                prevItems.filter(item => item !== value)
              );
            }}
            spritemap={spritemap}
            title={"Message:"}
          >Todo item was saved.</ClayAlert>
        ))}
      </ClayAlert.ToastContainer>


        </div>
    );
});

export default ViewEntry;


