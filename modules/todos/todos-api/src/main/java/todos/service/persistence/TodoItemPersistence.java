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

package todos.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

import todos.exception.NoSuchTodoItemException;

import todos.model.TodoItem;

/**
 * The persistence interface for the todo item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TodoItemUtil
 * @generated
 */
@ProviderType
public interface TodoItemPersistence extends BasePersistence<TodoItem> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TodoItemUtil} to access the todo item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the todo items where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching todo items
	 */
	public java.util.List<TodoItem> findByUuid(String uuid);

	/**
	 * Returns a range of all the todo items where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoItemModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of todo items
	 * @param end the upper bound of the range of todo items (not inclusive)
	 * @return the range of matching todo items
	 */
	public java.util.List<TodoItem> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the todo items where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoItemModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of todo items
	 * @param end the upper bound of the range of todo items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching todo items
	 */
	public java.util.List<TodoItem> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TodoItem>
			orderByComparator);

	/**
	 * Returns an ordered range of all the todo items where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoItemModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of todo items
	 * @param end the upper bound of the range of todo items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching todo items
	 */
	public java.util.List<TodoItem> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TodoItem>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first todo item in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo item
	 * @throws NoSuchTodoItemException if a matching todo item could not be found
	 */
	public TodoItem findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TodoItem>
				orderByComparator)
		throws NoSuchTodoItemException;

	/**
	 * Returns the first todo item in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo item, or <code>null</code> if a matching todo item could not be found
	 */
	public TodoItem fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TodoItem>
			orderByComparator);

	/**
	 * Returns the last todo item in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo item
	 * @throws NoSuchTodoItemException if a matching todo item could not be found
	 */
	public TodoItem findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TodoItem>
				orderByComparator)
		throws NoSuchTodoItemException;

	/**
	 * Returns the last todo item in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo item, or <code>null</code> if a matching todo item could not be found
	 */
	public TodoItem fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TodoItem>
			orderByComparator);

	/**
	 * Returns the todo items before and after the current todo item in the ordered set where uuid = &#63;.
	 *
	 * @param todoItemId the primary key of the current todo item
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next todo item
	 * @throws NoSuchTodoItemException if a todo item with the primary key could not be found
	 */
	public TodoItem[] findByUuid_PrevAndNext(
			long todoItemId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TodoItem>
				orderByComparator)
		throws NoSuchTodoItemException;

	/**
	 * Removes all the todo items where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of todo items where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching todo items
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the todo item where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTodoItemException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching todo item
	 * @throws NoSuchTodoItemException if a matching todo item could not be found
	 */
	public TodoItem findByUUID_G(String uuid, long groupId)
		throws NoSuchTodoItemException;

	/**
	 * Returns the todo item where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching todo item, or <code>null</code> if a matching todo item could not be found
	 */
	public TodoItem fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the todo item where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching todo item, or <code>null</code> if a matching todo item could not be found
	 */
	public TodoItem fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the todo item where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the todo item that was removed
	 */
	public TodoItem removeByUUID_G(String uuid, long groupId)
		throws NoSuchTodoItemException;

	/**
	 * Returns the number of todo items where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching todo items
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the todo items where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching todo items
	 */
	public java.util.List<TodoItem> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the todo items where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoItemModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of todo items
	 * @param end the upper bound of the range of todo items (not inclusive)
	 * @return the range of matching todo items
	 */
	public java.util.List<TodoItem> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the todo items where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoItemModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of todo items
	 * @param end the upper bound of the range of todo items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching todo items
	 */
	public java.util.List<TodoItem> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TodoItem>
			orderByComparator);

	/**
	 * Returns an ordered range of all the todo items where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoItemModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of todo items
	 * @param end the upper bound of the range of todo items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching todo items
	 */
	public java.util.List<TodoItem> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TodoItem>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first todo item in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo item
	 * @throws NoSuchTodoItemException if a matching todo item could not be found
	 */
	public TodoItem findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TodoItem>
				orderByComparator)
		throws NoSuchTodoItemException;

	/**
	 * Returns the first todo item in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo item, or <code>null</code> if a matching todo item could not be found
	 */
	public TodoItem fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TodoItem>
			orderByComparator);

	/**
	 * Returns the last todo item in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo item
	 * @throws NoSuchTodoItemException if a matching todo item could not be found
	 */
	public TodoItem findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TodoItem>
				orderByComparator)
		throws NoSuchTodoItemException;

	/**
	 * Returns the last todo item in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo item, or <code>null</code> if a matching todo item could not be found
	 */
	public TodoItem fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TodoItem>
			orderByComparator);

	/**
	 * Returns the todo items before and after the current todo item in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param todoItemId the primary key of the current todo item
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next todo item
	 * @throws NoSuchTodoItemException if a todo item with the primary key could not be found
	 */
	public TodoItem[] findByUuid_C_PrevAndNext(
			long todoItemId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TodoItem>
				orderByComparator)
		throws NoSuchTodoItemException;

	/**
	 * Removes all the todo items where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of todo items where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching todo items
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the todo items where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the matching todo items
	 */
	public java.util.List<TodoItem> findByCompanyIdGroupId(
		long companyId, long groupId);

	/**
	 * Returns a range of all the todo items where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoItemModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of todo items
	 * @param end the upper bound of the range of todo items (not inclusive)
	 * @return the range of matching todo items
	 */
	public java.util.List<TodoItem> findByCompanyIdGroupId(
		long companyId, long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the todo items where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoItemModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of todo items
	 * @param end the upper bound of the range of todo items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching todo items
	 */
	public java.util.List<TodoItem> findByCompanyIdGroupId(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TodoItem>
			orderByComparator);

	/**
	 * Returns an ordered range of all the todo items where companyId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoItemModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of todo items
	 * @param end the upper bound of the range of todo items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching todo items
	 */
	public java.util.List<TodoItem> findByCompanyIdGroupId(
		long companyId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TodoItem>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first todo item in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo item
	 * @throws NoSuchTodoItemException if a matching todo item could not be found
	 */
	public TodoItem findByCompanyIdGroupId_First(
			long companyId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<TodoItem>
				orderByComparator)
		throws NoSuchTodoItemException;

	/**
	 * Returns the first todo item in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching todo item, or <code>null</code> if a matching todo item could not be found
	 */
	public TodoItem fetchByCompanyIdGroupId_First(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<TodoItem>
			orderByComparator);

	/**
	 * Returns the last todo item in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo item
	 * @throws NoSuchTodoItemException if a matching todo item could not be found
	 */
	public TodoItem findByCompanyIdGroupId_Last(
			long companyId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<TodoItem>
				orderByComparator)
		throws NoSuchTodoItemException;

	/**
	 * Returns the last todo item in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching todo item, or <code>null</code> if a matching todo item could not be found
	 */
	public TodoItem fetchByCompanyIdGroupId_Last(
		long companyId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<TodoItem>
			orderByComparator);

	/**
	 * Returns the todo items before and after the current todo item in the ordered set where companyId = &#63; and groupId = &#63;.
	 *
	 * @param todoItemId the primary key of the current todo item
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next todo item
	 * @throws NoSuchTodoItemException if a todo item with the primary key could not be found
	 */
	public TodoItem[] findByCompanyIdGroupId_PrevAndNext(
			long todoItemId, long companyId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<TodoItem>
				orderByComparator)
		throws NoSuchTodoItemException;

	/**
	 * Removes all the todo items where companyId = &#63; and groupId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 */
	public void removeByCompanyIdGroupId(long companyId, long groupId);

	/**
	 * Returns the number of todo items where companyId = &#63; and groupId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param groupId the group ID
	 * @return the number of matching todo items
	 */
	public int countByCompanyIdGroupId(long companyId, long groupId);

	/**
	 * Caches the todo item in the entity cache if it is enabled.
	 *
	 * @param todoItem the todo item
	 */
	public void cacheResult(TodoItem todoItem);

	/**
	 * Caches the todo items in the entity cache if it is enabled.
	 *
	 * @param todoItems the todo items
	 */
	public void cacheResult(java.util.List<TodoItem> todoItems);

	/**
	 * Creates a new todo item with the primary key. Does not add the todo item to the database.
	 *
	 * @param todoItemId the primary key for the new todo item
	 * @return the new todo item
	 */
	public TodoItem create(long todoItemId);

	/**
	 * Removes the todo item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param todoItemId the primary key of the todo item
	 * @return the todo item that was removed
	 * @throws NoSuchTodoItemException if a todo item with the primary key could not be found
	 */
	public TodoItem remove(long todoItemId) throws NoSuchTodoItemException;

	public TodoItem updateImpl(TodoItem todoItem);

	/**
	 * Returns the todo item with the primary key or throws a <code>NoSuchTodoItemException</code> if it could not be found.
	 *
	 * @param todoItemId the primary key of the todo item
	 * @return the todo item
	 * @throws NoSuchTodoItemException if a todo item with the primary key could not be found
	 */
	public TodoItem findByPrimaryKey(long todoItemId)
		throws NoSuchTodoItemException;

	/**
	 * Returns the todo item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param todoItemId the primary key of the todo item
	 * @return the todo item, or <code>null</code> if a todo item with the primary key could not be found
	 */
	public TodoItem fetchByPrimaryKey(long todoItemId);

	/**
	 * Returns all the todo items.
	 *
	 * @return the todo items
	 */
	public java.util.List<TodoItem> findAll();

	/**
	 * Returns a range of all the todo items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoItemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of todo items
	 * @param end the upper bound of the range of todo items (not inclusive)
	 * @return the range of todo items
	 */
	public java.util.List<TodoItem> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the todo items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoItemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of todo items
	 * @param end the upper bound of the range of todo items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of todo items
	 */
	public java.util.List<TodoItem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TodoItem>
			orderByComparator);

	/**
	 * Returns an ordered range of all the todo items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TodoItemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of todo items
	 * @param end the upper bound of the range of todo items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of todo items
	 */
	public java.util.List<TodoItem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TodoItem>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the todo items from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of todo items.
	 *
	 * @return the number of todo items
	 */
	public int countAll();

}