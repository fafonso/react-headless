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

package todos.service.impl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import org.osgi.service.component.annotations.Component;

import org.osgi.service.component.annotations.Reference;
import todos.model.TodoItem;
import todos.service.TodoItemLocalService;
import todos.service.base.TodoItemServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the todo item remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>todos.service.TodoItemService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TodoItemServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=jb",
		"json.web.service.context.path=TodoItem"
	},
	service = AopService.class
)
public class TodoItemServiceImpl extends TodoItemServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>todos.service.TodoItemServiceUtil</code> to access the todo item remote service.
	 */

	public TodoItem addTodoItem(long companyId, long groupId, String name, String description){
		return _todoItemLocalService.addTodoItem(companyId, groupId, name, description);
	}

	public TodoItem updateTodoItem(long todoItemId, long companyId, long groupId, String name, String description){
		return _todoItemLocalService.updateTodoItem(todoItemId, companyId, groupId, name, description);
	}

	public List<TodoItem> getTodoItemList(long companyId, long groupId, String keywords, int start, int delta){
		return _todoItemLocalService.getTodoItemList(companyId, groupId, keywords, start, delta);
	}

	public int getTodoItemListCount(long companyId, long groupId, String keywords){
		return _todoItemLocalService.getTodoItemListCount(companyId, groupId, keywords);
	}

	public TodoItem deleteTodoItem(long todoItemId) throws PortalException {
		return _todoItemLocalService.deleteTodoItem(todoItemId);
	}

	public TodoItem getTodoItem(long todoItemId){
		return _todoItemLocalService.fetchTodoItem(todoItemId);
	}

	public List<TodoItem> searchTodoItemList(long companyId, long groupId, String keywords, int start, int end){
		return _todoItemLocalService.searchTodoItemList(companyId, groupId, keywords, start, end);
	}

	@Reference
	private TodoItemLocalService _todoItemLocalService;
}