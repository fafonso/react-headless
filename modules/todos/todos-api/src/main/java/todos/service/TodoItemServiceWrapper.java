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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TodoItemService}.
 *
 * @author Brian Wing Shun Chan
 * @see TodoItemService
 * @generated
 */
public class TodoItemServiceWrapper
	implements ServiceWrapper<TodoItemService>, TodoItemService {

	public TodoItemServiceWrapper(TodoItemService todoItemService) {
		_todoItemService = todoItemService;
	}

	@Override
	public todos.model.TodoItem addTodoItem(
		long companyId, long groupId, String name, String description) {

		return _todoItemService.addTodoItem(
			companyId, groupId, name, description);
	}

	@Override
	public todos.model.TodoItem deleteTodoItem(long todoItemId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _todoItemService.deleteTodoItem(todoItemId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _todoItemService.getOSGiServiceIdentifier();
	}

	@Override
	public todos.model.TodoItem getTodoItem(long todoItemId) {
		return _todoItemService.getTodoItem(todoItemId);
	}

	@Override
	public java.util.List<todos.model.TodoItem> getTodoItemList(
		long companyId, long groupId, String keywords, int start, int delta) {

		return _todoItemService.getTodoItemList(
			companyId, groupId, keywords, start, delta);
	}

	@Override
	public int getTodoItemListCount(
		long companyId, long groupId, String keywords) {

		return _todoItemService.getTodoItemListCount(
			companyId, groupId, keywords);
	}

	@Override
	public java.util.List<todos.model.TodoItem> searchTodoItemList(
		long companyId, long groupId, String keywords, int start, int end) {

		return _todoItemService.searchTodoItemList(
			companyId, groupId, keywords, start, end);
	}

	@Override
	public todos.model.TodoItem updateTodoItem(
		long todoItemId, long companyId, long groupId, String name,
		String description) {

		return _todoItemService.updateTodoItem(
			todoItemId, companyId, groupId, name, description);
	}

	@Override
	public TodoItemService getWrappedService() {
		return _todoItemService;
	}

	@Override
	public void setWrappedService(TodoItemService todoItemService) {
		_todoItemService = todoItemService;
	}

	private TodoItemService _todoItemService;

}