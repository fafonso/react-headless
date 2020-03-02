/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package todos.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for TodoItem. This utility wraps
 * <code>todos.service.impl.TodoItemLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TodoItemLocalService
 * @generated
 */
public class TodoItemLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>todos.service.impl.TodoItemLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static todos.model.TodoItem addTodoItem(
		long companyId, long groupId, String name, String description) {

		return getService().addTodoItem(companyId, groupId, name, description);
	}

	/**
	 * Adds the todo item to the database. Also notifies the appropriate model listeners.
	 *
	 * @param todoItem the todo item
	 * @return the todo item that was added
	 */
	public static todos.model.TodoItem addTodoItem(
		todos.model.TodoItem todoItem) {

		return getService().addTodoItem(todoItem);
	}

	/**
	 * Creates a new todo item with the primary key. Does not add the todo item to the database.
	 *
	 * @param todoItemId the primary key for the new todo item
	 * @return the new todo item
	 */
	public static todos.model.TodoItem createTodoItem(long todoItemId) {
		return getService().createTodoItem(todoItemId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the todo item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param todoItemId the primary key of the todo item
	 * @return the todo item that was removed
	 * @throws PortalException if a todo item with the primary key could not be found
	 */
	public static todos.model.TodoItem deleteTodoItem(long todoItemId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteTodoItem(todoItemId);
	}

	/**
	 * Deletes the todo item from the database. Also notifies the appropriate model listeners.
	 *
	 * @param todoItem the todo item
	 * @return the todo item that was removed
	 */
	public static todos.model.TodoItem deleteTodoItem(
		todos.model.TodoItem todoItem) {

		return getService().deleteTodoItem(todoItem);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>todos.model.impl.TodoItemModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>todos.model.impl.TodoItemModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static todos.model.TodoItem fetchTodoItem(long todoItemId) {
		return getService().fetchTodoItem(todoItemId);
	}

	/**
	 * Returns the todo item matching the UUID and group.
	 *
	 * @param uuid the todo item's UUID
	 * @param groupId the primary key of the group
	 * @return the matching todo item, or <code>null</code> if a matching todo item could not be found
	 */
	public static todos.model.TodoItem fetchTodoItemByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchTodoItemByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the todo item with the primary key.
	 *
	 * @param todoItemId the primary key of the todo item
	 * @return the todo item
	 * @throws PortalException if a todo item with the primary key could not be found
	 */
	public static todos.model.TodoItem getTodoItem(long todoItemId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getTodoItem(todoItemId);
	}

	/**
	 * Returns the todo item matching the UUID and group.
	 *
	 * @param uuid the todo item's UUID
	 * @param groupId the primary key of the group
	 * @return the matching todo item
	 * @throws PortalException if a matching todo item could not be found
	 */
	public static todos.model.TodoItem getTodoItemByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getTodoItemByUuidAndGroupId(uuid, groupId);
	}

	public static java.util.List<todos.model.TodoItem> getTodoItemList(
		long companyId, long groupId, String keywords, int start, int end) {

		return getService().getTodoItemList(
			companyId, groupId, keywords, start, end);
	}

	public static int getTodoItemListCount(
		long companyId, long groupId, String keywords) {

		return getService().getTodoItemListCount(companyId, groupId, keywords);
	}

	/**
	 * Returns a range of all the todo items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>todos.model.impl.TodoItemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of todo items
	 * @param end the upper bound of the range of todo items (not inclusive)
	 * @return the range of todo items
	 */
	public static java.util.List<todos.model.TodoItem> getTodoItems(
		int start, int end) {

		return getService().getTodoItems(start, end);
	}

	/**
	 * Returns all the todo items matching the UUID and company.
	 *
	 * @param uuid the UUID of the todo items
	 * @param companyId the primary key of the company
	 * @return the matching todo items, or an empty list if no matches were found
	 */
	public static java.util.List<todos.model.TodoItem>
		getTodoItemsByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getTodoItemsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of todo items matching the UUID and company.
	 *
	 * @param uuid the UUID of the todo items
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of todo items
	 * @param end the upper bound of the range of todo items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching todo items, or an empty list if no matches were found
	 */
	public static java.util.List<todos.model.TodoItem>
		getTodoItemsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<todos.model.TodoItem> orderByComparator) {

		return getService().getTodoItemsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of todo items.
	 *
	 * @return the number of todo items
	 */
	public static int getTodoItemsCount() {
		return getService().getTodoItemsCount();
	}

	public static java.util.List<todos.model.TodoItem> searchTodoItemList(
		long companyId, long groupId, String keywords, int start, int end) {

		return getService().searchTodoItemList(
			companyId, groupId, keywords, start, end);
	}

	public static todos.model.TodoItem updateTodoItem(
		long todoItemId, long companyId, long groupId, String name,
		String description) {

		return getService().updateTodoItem(
			todoItemId, companyId, groupId, name, description);
	}

	/**
	 * Updates the todo item in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param todoItem the todo item
	 * @return the todo item that was updated
	 */
	public static todos.model.TodoItem updateTodoItem(
		todos.model.TodoItem todoItem) {

		return getService().updateTodoItem(todoItem);
	}

	public static TodoItemLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TodoItemLocalService, TodoItemLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TodoItemLocalService.class);

		ServiceTracker<TodoItemLocalService, TodoItemLocalService>
			serviceTracker =
				new ServiceTracker<TodoItemLocalService, TodoItemLocalService>(
					bundle.getBundleContext(), TodoItemLocalService.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}