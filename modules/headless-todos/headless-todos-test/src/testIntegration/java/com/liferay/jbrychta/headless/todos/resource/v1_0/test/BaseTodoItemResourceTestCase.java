package com.liferay.jbrychta.headless.todos.resource.v1_0.test;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import com.liferay.jbrychta.headless.todos.client.dto.v1_0.TodoItem;
import com.liferay.jbrychta.headless.todos.client.http.HttpInvoker;
import com.liferay.jbrychta.headless.todos.client.pagination.Page;
import com.liferay.jbrychta.headless.todos.client.pagination.Pagination;
import com.liferay.jbrychta.headless.todos.client.resource.v1_0.TodoItemResource;
import com.liferay.jbrychta.headless.todos.client.serdes.v1_0.TodoItemSerDes;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.resource.EntityModelResource;

import java.lang.reflect.InvocationTargetException;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Generated;

import javax.ws.rs.core.MultivaluedHashMap;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.lang.time.DateUtils;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Jan Brychta
 * @generated
 */
@Generated("")
public abstract class BaseTodoItemResourceTestCase {

	@ClassRule
	@Rule
	public static final LiferayIntegrationTestRule liferayIntegrationTestRule =
		new LiferayIntegrationTestRule();

	@BeforeClass
	public static void setUpClass() throws Exception {
		_dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");
	}

	@Before
	public void setUp() throws Exception {
		irrelevantGroup = GroupTestUtil.addGroup();
		testGroup = GroupTestUtil.addGroup();
		testLocale = LocaleUtil.getDefault();
	}

	@After
	public void tearDown() throws Exception {
		GroupTestUtil.deleteGroup(irrelevantGroup);
		GroupTestUtil.deleteGroup(testGroup);
	}

	@Test
	public void testClientSerDesToDTO() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				enable(SerializationFeature.INDENT_OUTPUT);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
			}
		};

		TodoItem todoItem1 = randomTodoItem();

		String json = objectMapper.writeValueAsString(todoItem1);

		TodoItem todoItem2 = TodoItemSerDes.toDTO(json);

		Assert.assertTrue(equals(todoItem1, todoItem2));
	}

	@Test
	public void testClientSerDesToJSON() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
			}
		};

		TodoItem todoItem = randomTodoItem();

		String json1 = objectMapper.writeValueAsString(todoItem);
		String json2 = TodoItemSerDes.toJSON(todoItem);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testGetTodosPage() throws Exception {
		TodoItem todoItem1 = testGetTodosPage_addTodoItem(randomTodoItem());

		TodoItem todoItem2 = testGetTodosPage_addTodoItem(randomTodoItem());

		Page<TodoItem> page = TodoItemResource.getTodosPage(
			null, null, Pagination.of(1, 2), null);

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(todoItem1, todoItem2),
			(List<TodoItem>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetTodosPageWithFilterDateTimeEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		TodoItem todoItem1 = randomTodoItem();

		todoItem1 = testGetTodosPage_addTodoItem(todoItem1);

		for (EntityField entityField : entityFields) {
			Page<TodoItem> page = TodoItemResource.getTodosPage(
				null, getFilterString(entityField, "between", todoItem1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(todoItem1),
				(List<TodoItem>)page.getItems());
		}
	}

	@Test
	public void testGetTodosPageWithFilterStringEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		TodoItem todoItem1 = testGetTodosPage_addTodoItem(randomTodoItem());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		TodoItem todoItem2 = testGetTodosPage_addTodoItem(randomTodoItem());

		for (EntityField entityField : entityFields) {
			Page<TodoItem> page = TodoItemResource.getTodosPage(
				null, getFilterString(entityField, "eq", todoItem1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(todoItem1),
				(List<TodoItem>)page.getItems());
		}
	}

	@Test
	public void testGetTodosPageWithPagination() throws Exception {
		TodoItem todoItem1 = testGetTodosPage_addTodoItem(randomTodoItem());

		TodoItem todoItem2 = testGetTodosPage_addTodoItem(randomTodoItem());

		TodoItem todoItem3 = testGetTodosPage_addTodoItem(randomTodoItem());

		Page<TodoItem> page1 = TodoItemResource.getTodosPage(
			null, null, Pagination.of(1, 2), null);

		List<TodoItem> todoItems1 = (List<TodoItem>)page1.getItems();

		Assert.assertEquals(todoItems1.toString(), 2, todoItems1.size());

		Page<TodoItem> page2 = TodoItemResource.getTodosPage(
			null, null, Pagination.of(2, 2), null);

		Assert.assertEquals(3, page2.getTotalCount());

		List<TodoItem> todoItems2 = (List<TodoItem>)page2.getItems();

		Assert.assertEquals(todoItems2.toString(), 1, todoItems2.size());

		assertEqualsIgnoringOrder(
			Arrays.asList(todoItem1, todoItem2, todoItem3),
			new ArrayList<TodoItem>() {
				{
					addAll(todoItems1);
					addAll(todoItems2);
				}
			});
	}

	@Test
	public void testGetTodosPageWithSortDateTime() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		TodoItem todoItem1 = randomTodoItem();
		TodoItem todoItem2 = randomTodoItem();

		for (EntityField entityField : entityFields) {
			BeanUtils.setProperty(
				todoItem1, entityField.getName(),
				DateUtils.addMinutes(new Date(), -2));
		}

		todoItem1 = testGetTodosPage_addTodoItem(todoItem1);

		todoItem2 = testGetTodosPage_addTodoItem(todoItem2);

		for (EntityField entityField : entityFields) {
			Page<TodoItem> ascPage = TodoItemResource.getTodosPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(todoItem1, todoItem2),
				(List<TodoItem>)ascPage.getItems());

			Page<TodoItem> descPage = TodoItemResource.getTodosPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(todoItem2, todoItem1),
				(List<TodoItem>)descPage.getItems());
		}
	}

	@Test
	public void testGetTodosPageWithSortString() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		TodoItem todoItem1 = randomTodoItem();
		TodoItem todoItem2 = randomTodoItem();

		for (EntityField entityField : entityFields) {
			BeanUtils.setProperty(todoItem1, entityField.getName(), "Aaa");
			BeanUtils.setProperty(todoItem2, entityField.getName(), "Bbb");
		}

		todoItem1 = testGetTodosPage_addTodoItem(todoItem1);

		todoItem2 = testGetTodosPage_addTodoItem(todoItem2);

		for (EntityField entityField : entityFields) {
			Page<TodoItem> ascPage = TodoItemResource.getTodosPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(todoItem1, todoItem2),
				(List<TodoItem>)ascPage.getItems());

			Page<TodoItem> descPage = TodoItemResource.getTodosPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(todoItem2, todoItem1),
				(List<TodoItem>)descPage.getItems());
		}
	}

	protected TodoItem testGetTodosPage_addTodoItem(TodoItem todoItem)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testPostTodo() throws Exception {
		TodoItem randomTodoItem = randomTodoItem();

		TodoItem postTodoItem = testPostTodo_addTodoItem(randomTodoItem);

		assertEquals(randomTodoItem, postTodoItem);
		assertValid(postTodoItem);
	}

	protected TodoItem testPostTodo_addTodoItem(TodoItem todoItem)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testDeleteTodoTodoItem() throws Exception {
		TodoItem todoItem = testDeleteTodoTodoItem_addTodoItem();

		assertHttpResponseStatusCode(
			204,
			TodoItemResource.deleteTodoTodoItemHttpResponse(todoItem.getId()));

		assertHttpResponseStatusCode(
			404,
			TodoItemResource.getTodoTodoItemHttpResponse(todoItem.getId()));

		assertHttpResponseStatusCode(
			404, TodoItemResource.getTodoTodoItemHttpResponse(0L));
	}

	protected TodoItem testDeleteTodoTodoItem_addTodoItem() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGetTodoTodoItem() throws Exception {
		TodoItem postTodoItem = testGetTodoTodoItem_addTodoItem();

		TodoItem getTodoItem = TodoItemResource.getTodoTodoItem(
			postTodoItem.getId());

		assertEquals(postTodoItem, getTodoItem);
		assertValid(getTodoItem);
	}

	protected TodoItem testGetTodoTodoItem_addTodoItem() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testPutTodoTodoItem() throws Exception {
		TodoItem postTodoItem = testPutTodoTodoItem_addTodoItem();

		TodoItem randomTodoItem = randomTodoItem();

		TodoItem putTodoItem = TodoItemResource.putTodoItem(
			postTodoItem.getId(), randomTodoItem);

		assertEquals(randomTodoItem, putTodoItem);
		assertValid(putTodoItem);

		TodoItem getTodoItem = TodoItemResource.getTodoItem(
			putTodoItem.getId());

		assertEquals(randomTodoItem, getTodoItem);
		assertValid(getTodoItem);
	}

	protected TodoItem testPutTodoTodoItem_addTodoItem() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(TodoItem todoItem1, TodoItem todoItem2) {
		Assert.assertTrue(
			todoItem1 + " does not equal " + todoItem2,
			equals(todoItem1, todoItem2));
	}

	protected void assertEquals(
		List<TodoItem> todoItems1, List<TodoItem> todoItems2) {

		Assert.assertEquals(todoItems1.size(), todoItems2.size());

		for (int i = 0; i < todoItems1.size(); i++) {
			TodoItem todoItem1 = todoItems1.get(i);
			TodoItem todoItem2 = todoItems2.get(i);

			assertEquals(todoItem1, todoItem2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<TodoItem> todoItems1, List<TodoItem> todoItems2) {

		Assert.assertEquals(todoItems1.size(), todoItems2.size());

		for (TodoItem todoItem1 : todoItems1) {
			boolean contains = false;

			for (TodoItem todoItem2 : todoItems2) {
				if (equals(todoItem1, todoItem2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				todoItems2 + " does not contain " + todoItem1, contains);
		}
	}

	protected void assertValid(TodoItem todoItem) {
		boolean valid = true;

		if (todoItem.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("creator", additionalAssertFieldName)) {
				if (todoItem.getCreator() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("description", additionalAssertFieldName)) {
				if (todoItem.getDescription() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (todoItem.getName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("priority", additionalAssertFieldName)) {
				if (todoItem.getPriority() == null) {
					valid = false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(Page<TodoItem> page) {
		boolean valid = false;

		Collection<TodoItem> todoItems = page.getItems();

		int size = todoItems.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);
	}

	protected String[] getAdditionalAssertFieldNames() {
		return new String[0];
	}

	protected boolean equals(TodoItem todoItem1, TodoItem todoItem2) {
		if (todoItem1 == todoItem2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("creator", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						todoItem1.getCreator(), todoItem2.getCreator())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("description", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						todoItem1.getDescription(),
						todoItem2.getDescription())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(todoItem1.getId(), todoItem2.getId())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						todoItem1.getName(), todoItem2.getName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("priority", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						todoItem1.getPriority(), todoItem2.getPriority())) {

					return false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		return true;
	}

	protected Collection<EntityField> getEntityFields() throws Exception {
		if (!(_todoItemResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_todoItemResource;

		EntityModel entityModel = entityModelResource.getEntityModel(
			new MultivaluedHashMap());

		Map<String, EntityField> entityFieldsMap =
			entityModel.getEntityFieldsMap();

		return entityFieldsMap.values();
	}

	protected List<EntityField> getEntityFields(EntityField.Type type)
		throws Exception {

		Collection<EntityField> entityFields = getEntityFields();

		Stream<EntityField> stream = entityFields.stream();

		return stream.filter(
			entityField -> Objects.equals(entityField.getType(), type)
		).collect(
			Collectors.toList()
		);
	}

	protected String getFilterString(
		EntityField entityField, String operator, TodoItem todoItem) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("creator")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("description")) {
			sb.append("'");
			sb.append(String.valueOf(todoItem.getDescription()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("id")) {
			sb.append("'");
			sb.append(String.valueOf(todoItem.getId()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("name")) {
			sb.append("'");
			sb.append(String.valueOf(todoItem.getName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("priority")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected TodoItem randomTodoItem() throws Exception {
		return new TodoItem() {
			{
				description = RandomTestUtil.randomString();
				id = RandomTestUtil.randomString();
				name = RandomTestUtil.randomString();
			}
		};
	}

	protected TodoItem randomIrrelevantTodoItem() throws Exception {
		TodoItem randomIrrelevantTodoItem = randomTodoItem();

		return randomIrrelevantTodoItem;
	}

	protected TodoItem randomPatchTodoItem() throws Exception {
		return randomTodoItem();
	}

	protected Group irrelevantGroup;
	protected Group testGroup;
	protected Locale testLocale;
	protected String testUserNameAndPassword = "test@liferay.com:test";

	private static final Log _log = LogFactoryUtil.getLog(
		BaseTodoItemResourceTestCase.class);

	private static BeanUtilsBean _beanUtilsBean = new BeanUtilsBean() {

		@Override
		public void copyProperty(Object bean, String name, Object value)
			throws IllegalAccessException, InvocationTargetException {

			if (value != null) {
				super.copyProperty(bean, name, value);
			}
		}

	};
	private static DateFormat _dateFormat;

	@Inject
	private com.liferay.jbrychta.headless.todos.resource.v1_0.TodoItemResource
		_todoItemResource;

}