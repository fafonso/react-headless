package com.liferay.jbrychta.headless.todos.internal.graphql.mutation.v1_0;

import com.liferay.jbrychta.headless.todos.dto.v1_0.TodoItem;
import com.liferay.jbrychta.headless.todos.resource.v1_0.TodoItemResource;
import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;

import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLInvokeDetached;
import graphql.annotations.annotationTypes.GraphQLName;

import javax.annotation.Generated;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author Jan Brychta
 * @generated
 */
@Generated("")
public class Mutation {

	public static void setTodoItemResourceComponentServiceObjects(
		ComponentServiceObjects<TodoItemResource>
			todoItemResourceComponentServiceObjects) {

		_todoItemResourceComponentServiceObjects =
			todoItemResourceComponentServiceObjects;
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public TodoItem postTodo(@GraphQLName("todoItem") TodoItem todoItem)
		throws Exception {

		return _applyComponentServiceObjects(
			_todoItemResourceComponentServiceObjects,
			this::_populateResourceContext,
			todoItemResource -> todoItemResource.postTodo(todoItem));
	}

	@GraphQLInvokeDetached
	public TodoItem deleteTodoTodoItem(
			@GraphQLName("todoItemId") Integer todoItemId)
		throws Exception {

		return _applyComponentServiceObjects(
			_todoItemResourceComponentServiceObjects,
			this::_populateResourceContext,
			todoItemResource -> todoItemResource.deleteTodoTodoItem(
				todoItemId));
	}

	@GraphQLInvokeDetached
	public TodoItem putTodoTodoItem(
			@GraphQLName("todoItemId") String todoItemId,
			@GraphQLName("todoItem") TodoItem todoItem)
		throws Exception {

		return _applyComponentServiceObjects(
			_todoItemResourceComponentServiceObjects,
			this::_populateResourceContext,
			todoItemResource -> todoItemResource.putTodoTodoItem(
				todoItemId, todoItem));
	}

	private <T, R, E1 extends Throwable, E2 extends Throwable> R
			_applyComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeFunction<T, R, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			return unsafeFunction.apply(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private <T, E1 extends Throwable, E2 extends Throwable> void
			_applyVoidComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeConsumer<T, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			unsafeFunction.accept(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private void _populateResourceContext(TodoItemResource todoItemResource)
		throws Exception {

		todoItemResource.setContextCompany(
			CompanyLocalServiceUtil.getCompany(
				CompanyThreadLocal.getCompanyId()));
	}

	private static ComponentServiceObjects<TodoItemResource>
		_todoItemResourceComponentServiceObjects;

}