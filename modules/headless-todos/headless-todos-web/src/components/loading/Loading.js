import ClayLoadingIndicator from '@clayui/loading-indicator';
import React from 'react';

export const withLoading = Component => {

	const Wrapper = props => {
		const {isLoading, ...restProps} = props;

		if (isLoading) {
			return (
				<div className="align-items-center d-flex loading-wrapper">
					<ClayLoadingIndicator />
				</div>
			);
		}

		return <Component {...restProps} />;
	};

	return Wrapper;
};

export const Loading = withLoading(({children}) => <div>{children}</div>);