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
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import todos.service.TodoItemServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>TodoItemServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TodoItemServiceSoap
 * @generated
 */
public class TodoItemServiceHttp {

	public static todos.model.TodoItem addTodoItem(
		HttpPrincipal httpPrincipal, long companyId, long groupId, String name,
		String description) {

		try {
			MethodKey methodKey = new MethodKey(
				TodoItemServiceUtil.class, "addTodoItem",
				_addTodoItemParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, companyId, groupId, name, description);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (todos.model.TodoItem)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static todos.model.TodoItem updateTodoItem(
		HttpPrincipal httpPrincipal, long todoItemId, long companyId,
		long groupId, String name, String description) {

		try {
			MethodKey methodKey = new MethodKey(
				TodoItemServiceUtil.class, "updateTodoItem",
				_updateTodoItemParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, todoItemId, companyId, groupId, name, description);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (todos.model.TodoItem)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<todos.model.TodoItem> getTodoItemList(
		HttpPrincipal httpPrincipal, long companyId, long groupId,
		String keywords, int start, int delta) {

		try {
			MethodKey methodKey = new MethodKey(
				TodoItemServiceUtil.class, "getTodoItemList",
				_getTodoItemListParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, companyId, groupId, keywords, start, delta);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (java.util.List<todos.model.TodoItem>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static int getTodoItemListCount(
		HttpPrincipal httpPrincipal, long companyId, long groupId,
		String keywords) {

		try {
			MethodKey methodKey = new MethodKey(
				TodoItemServiceUtil.class, "getTodoItemListCount",
				_getTodoItemListCountParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, companyId, groupId, keywords);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static todos.model.TodoItem deleteTodoItem(
			HttpPrincipal httpPrincipal, long todoItemId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				TodoItemServiceUtil.class, "deleteTodoItem",
				_deleteTodoItemParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, todoItemId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (todos.model.TodoItem)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static todos.model.TodoItem getTodoItem(
		HttpPrincipal httpPrincipal, long todoItemId) {

		try {
			MethodKey methodKey = new MethodKey(
				TodoItemServiceUtil.class, "getTodoItem",
				_getTodoItemParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, todoItemId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (todos.model.TodoItem)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<todos.model.TodoItem> searchTodoItemList(
		HttpPrincipal httpPrincipal, long companyId, long groupId,
		String keywords, int start, int end) {

		try {
			MethodKey methodKey = new MethodKey(
				TodoItemServiceUtil.class, "searchTodoItemList",
				_searchTodoItemListParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, companyId, groupId, keywords, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (java.util.List<todos.model.TodoItem>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(TodoItemServiceHttp.class);

	private static final Class<?>[] _addTodoItemParameterTypes0 = new Class[] {
		long.class, long.class, String.class, String.class
	};
	private static final Class<?>[] _updateTodoItemParameterTypes1 =
		new Class[] {
			long.class, long.class, long.class, String.class, String.class
		};
	private static final Class<?>[] _getTodoItemListParameterTypes2 =
		new Class[] {
			long.class, long.class, String.class, int.class, int.class
		};
	private static final Class<?>[] _getTodoItemListCountParameterTypes3 =
		new Class[] {long.class, long.class, String.class};
	private static final Class<?>[] _deleteTodoItemParameterTypes4 =
		new Class[] {long.class};
	private static final Class<?>[] _getTodoItemParameterTypes5 = new Class[] {
		long.class
	};
	private static final Class<?>[] _searchTodoItemListParameterTypes6 =
		new Class[] {
			long.class, long.class, String.class, int.class, int.class
		};

}