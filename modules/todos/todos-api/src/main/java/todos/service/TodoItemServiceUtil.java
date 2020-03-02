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
 * Provides the remote service utility for TodoItem. This utility wraps
 * <code>todos.service.impl.TodoItemServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see TodoItemService
 * @generated
 */
public class TodoItemServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>todos.service.impl.TodoItemServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static todos.model.TodoItem addTodoItem(
		long companyId, long groupId, String name, String description) {

		return getService().addTodoItem(companyId, groupId, name, description);
	}

	public static todos.model.TodoItem deleteTodoItem(long todoItemId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteTodoItem(todoItemId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static todos.model.TodoItem getTodoItem(long todoItemId) {
		return getService().getTodoItem(todoItemId);
	}

	public static java.util.List<todos.model.TodoItem> getTodoItemList(
		long companyId, long groupId, String keywords, int start, int delta) {

		return getService().getTodoItemList(
			companyId, groupId, keywords, start, delta);
	}

	public static int getTodoItemListCount(
		long companyId, long groupId, String keywords) {

		return getService().getTodoItemListCount(companyId, groupId, keywords);
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

	public static TodoItemService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TodoItemService, TodoItemService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TodoItemService.class);

		ServiceTracker<TodoItemService, TodoItemService> serviceTracker =
			new ServiceTracker<TodoItemService, TodoItemService>(
				bundle.getBundleContext(), TodoItemService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}