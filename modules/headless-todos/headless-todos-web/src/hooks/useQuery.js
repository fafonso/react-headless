import {useEffect, useRef, useState} from 'react';

export const toQuery = (string, defaultQuery = {}) => {
	const query = {...defaultQuery};
	const params = new URLSearchParams(string);

	params.forEach((value, key) => {
		query[key] = value;
	});

	return query;
};

export const toQueryString = (object, queryString = '') => {
	const params = new URLSearchParams(queryString);

	Object.keys(object).forEach(key => {
		if (object[key]) {
			params.set(key, object[key]);
		}
		else {
			params.delete(key);
		}
	});

	return params.toString();
};

export default (history, defaultQuery = {}) => {
	const {location} = history;
	const {pathname, search} = location;
	const defaultQueryRef = useRef(defaultQuery);
	const [query, setQuery] = useState(
		toQuery(search, defaultQueryRef.current)
	);

	useEffect(() => {
		setQuery(toQuery(search, defaultQueryRef.current));
	}, [defaultQueryRef, search]);

	return [
		query,
		query => history.push(`${pathname}?${toQueryString(query, search)}`)
	];
};
