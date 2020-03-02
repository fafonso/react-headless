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

package todos.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import todos.model.TodoItem;

/**
 * The cache model class for representing TodoItem in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TodoItemCacheModel
	implements CacheModel<TodoItem>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TodoItemCacheModel)) {
			return false;
		}

		TodoItemCacheModel todoItemCacheModel = (TodoItemCacheModel)obj;

		if (todoItemId == todoItemCacheModel.todoItemId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, todoItemId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", todoItemId=");
		sb.append(todoItemId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", priority=");
		sb.append(priority);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TodoItem toEntityModel() {
		TodoItemImpl todoItemImpl = new TodoItemImpl();

		if (uuid == null) {
			todoItemImpl.setUuid("");
		}
		else {
			todoItemImpl.setUuid(uuid);
		}

		todoItemImpl.setTodoItemId(todoItemId);
		todoItemImpl.setGroupId(groupId);
		todoItemImpl.setCompanyId(companyId);
		todoItemImpl.setUserId(userId);

		if (userName == null) {
			todoItemImpl.setUserName("");
		}
		else {
			todoItemImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			todoItemImpl.setCreateDate(null);
		}
		else {
			todoItemImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			todoItemImpl.setModifiedDate(null);
		}
		else {
			todoItemImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			todoItemImpl.setName("");
		}
		else {
			todoItemImpl.setName(name);
		}

		if (description == null) {
			todoItemImpl.setDescription("");
		}
		else {
			todoItemImpl.setDescription(description);
		}

		todoItemImpl.setPriority(priority);

		todoItemImpl.resetOriginalValues();

		return todoItemImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		todoItemId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();

		priority = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(todoItemId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeInt(priority);
	}

	public String uuid;
	public long todoItemId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String description;
	public int priority;

}