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

package todos.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

import todos.service.TodoItemServiceUtil;

/**
 * Provides the SOAP utility for the
 * <code>TodoItemServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>todos.model.TodoItemSoap</code>. If the method in the
 * service utility returns a
 * <code>todos.model.TodoItem</code>, that is translated to a
 * <code>todos.model.TodoItemSoap</code>. Methods that SOAP
 * cannot safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TodoItemServiceHttp
 * @generated
 */
public class TodoItemServiceSoap {

	public static todos.model.TodoItemSoap addTodoItem(
			long companyId, long groupId, String name, String description)
		throws RemoteException {

		try {
			todos.model.TodoItem returnValue = TodoItemServiceUtil.addTodoItem(
				companyId, groupId, name, description);

			return todos.model.TodoItemSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static todos.model.TodoItemSoap updateTodoItem(
			long todoItemId, long companyId, long groupId, String name,
			String description)
		throws RemoteException {

		try {
			todos.model.TodoItem returnValue =
				TodoItemServiceUtil.updateTodoItem(
					todoItemId, companyId, groupId, name, description);

			return todos.model.TodoItemSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static todos.model.TodoItemSoap[] getTodoItemList(
			long companyId, long groupId, String keywords, int start, int delta)
		throws RemoteException {

		try {
			java.util.List<todos.model.TodoItem> returnValue =
				TodoItemServiceUtil.getTodoItemList(
					companyId, groupId, keywords, start, delta);

			return todos.model.TodoItemSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int getTodoItemListCount(
			long companyId, long groupId, String keywords)
		throws RemoteException {

		try {
			int returnValue = TodoItemServiceUtil.getTodoItemListCount(
				companyId, groupId, keywords);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static todos.model.TodoItemSoap deleteTodoItem(long todoItemId)
		throws RemoteException {

		try {
			todos.model.TodoItem returnValue =
				TodoItemServiceUtil.deleteTodoItem(todoItemId);

			return todos.model.TodoItemSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static todos.model.TodoItemSoap getTodoItem(long todoItemId)
		throws RemoteException {

		try {
			todos.model.TodoItem returnValue = TodoItemServiceUtil.getTodoItem(
				todoItemId);

			return todos.model.TodoItemSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static todos.model.TodoItemSoap[] searchTodoItemList(
			long companyId, long groupId, String keywords, int start, int end)
		throws RemoteException {

		try {
			java.util.List<todos.model.TodoItem> returnValue =
				TodoItemServiceUtil.searchTodoItemList(
					companyId, groupId, keywords, start, end);

			return todos.model.TodoItemSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(TodoItemServiceSoap.class);

}