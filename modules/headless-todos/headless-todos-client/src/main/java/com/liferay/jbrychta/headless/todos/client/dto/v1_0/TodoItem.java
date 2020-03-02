package com.liferay.jbrychta.headless.todos.client.dto.v1_0;

import com.liferay.jbrychta.headless.todos.client.function.UnsafeSupplier;
import com.liferay.jbrychta.headless.todos.client.serdes.v1_0.TodoItemSerDes;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Jan Brychta
 * @generated
 */
@Generated("")
public class TodoItem {

	public static enum Priority {

		HIGHT("Hight"), NORMAL("Normal"), LOW("Low");

		public static Priority create(String value) {
			for (Priority priority : values()) {
				if (Objects.equals(priority.getValue(), value)) {
					return priority;
				}
			}

			return null;
		}

		public String getValue() {
			return _value;
		}

		@Override
		public String toString() {
			return _value;
		}

		private Priority(String value) {
			_value = value;
		}

		private final String _value;

	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public void setCompanyId(
		UnsafeSupplier<Integer, Exception> companyIdUnsafeSupplier) {

		try {
			companyId = companyIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Integer companyId;

	public Creator getCreator() {
		return creator;
	}

	public void setCreator(Creator creator) {
		this.creator = creator;
	}

	public void setCreator(
		UnsafeSupplier<Creator, Exception> creatorUnsafeSupplier) {

		try {
			creator = creatorUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Creator creator;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDescription(
		UnsafeSupplier<String, Exception> descriptionUnsafeSupplier) {

		try {
			description = descriptionUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String description;

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public void setGroupId(
		UnsafeSupplier<Integer, Exception> groupIdUnsafeSupplier) {

		try {
			groupId = groupIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Integer groupId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setId(UnsafeSupplier<Integer, Exception> idUnsafeSupplier) {
		try {
			id = idUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Integer id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setName(UnsafeSupplier<String, Exception> nameUnsafeSupplier) {
		try {
			name = nameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String name;

	public Priority getPriority() {
		return priority;
	}

	public String getPriorityAsString() {
		if (priority == null) {
			return null;
		}

		return priority.toString();
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public void setPriority(
		UnsafeSupplier<Priority, Exception> priorityUnsafeSupplier) {

		try {
			priority = priorityUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Priority priority;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TodoItem)) {
			return false;
		}

		TodoItem todoItem = (TodoItem)object;

		return Objects.equals(toString(), todoItem.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return TodoItemSerDes.toJSON(this);
	}

}