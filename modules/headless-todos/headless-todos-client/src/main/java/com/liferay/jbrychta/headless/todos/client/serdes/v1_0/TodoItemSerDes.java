package com.liferay.jbrychta.headless.todos.client.serdes.v1_0;

import com.liferay.jbrychta.headless.todos.client.dto.v1_0.TodoItem;
import com.liferay.jbrychta.headless.todos.client.json.BaseJSONParser;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

/**
 * @author Jan Brychta
 * @generated
 */
@Generated("")
public class TodoItemSerDes {

	public static TodoItem toDTO(String json) {
		TodoItemJSONParser todoItemJSONParser = new TodoItemJSONParser();

		return todoItemJSONParser.parseToDTO(json);
	}

	public static TodoItem[] toDTOs(String json) {
		TodoItemJSONParser todoItemJSONParser = new TodoItemJSONParser();

		return todoItemJSONParser.parseToDTOs(json);
	}

	public static String toJSON(TodoItem todoItem) {
		if (todoItem == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (todoItem.getCreator() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"creator\": ");

			sb.append(String.valueOf(todoItem.getCreator()));
		}

		if (todoItem.getDescription() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"description\": ");

			sb.append("\"");

			sb.append(_escape(todoItem.getDescription()));

			sb.append("\"");
		}

		if (todoItem.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append("\"");

			sb.append(_escape(todoItem.getId()));

			sb.append("\"");
		}

		if (todoItem.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(todoItem.getName()));

			sb.append("\"");
		}

		if (todoItem.getPriority() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"priority\": ");

			sb.append("\"");

			sb.append(todoItem.getPriority());

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		TodoItemJSONParser todoItemJSONParser = new TodoItemJSONParser();

		return todoItemJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(TodoItem todoItem) {
		if (todoItem == null) {
			return null;
		}

		Map<String, String> map = new HashMap<>();

		if (todoItem.getCreator() == null) {
			map.put("creator", null);
		}
		else {
			map.put("creator", String.valueOf(todoItem.getCreator()));
		}

		if (todoItem.getDescription() == null) {
			map.put("description", null);
		}
		else {
			map.put("description", String.valueOf(todoItem.getDescription()));
		}

		if (todoItem.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(todoItem.getId()));
		}

		if (todoItem.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(todoItem.getName()));
		}

		if (todoItem.getPriority() == null) {
			map.put("priority", null);
		}
		else {
			map.put("priority", String.valueOf(todoItem.getPriority()));
		}

		return map;
	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		return string.replaceAll("\"", "\\\\\"");
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\":");
			sb.append("\"");
			sb.append(entry.getValue());
			sb.append("\"");

			if (iterator.hasNext()) {
				sb.append(",");
			}
		}

		sb.append("}");

		return sb.toString();
	}

	private static class TodoItemJSONParser extends BaseJSONParser<TodoItem> {

		@Override
		protected TodoItem createDTO() {
			return new TodoItem();
		}

		@Override
		protected TodoItem[] createDTOArray(int size) {
			return new TodoItem[size];
		}

		@Override
		protected void setField(
			TodoItem todoItem, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "creator")) {
				if (jsonParserFieldValue != null) {
					todoItem.setCreator(
						CreatorSerDes.toDTO((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "description")) {
				if (jsonParserFieldValue != null) {
					todoItem.setDescription((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					todoItem.setId((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					todoItem.setName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "priority")) {
				if (jsonParserFieldValue != null) {
					todoItem.setPriority(
						TodoItem.Priority.create((String)jsonParserFieldValue));
				}
			}
			else {
				throw new IllegalArgumentException(
					"Unsupported field name " + jsonParserFieldName);
			}
		}

	}

}