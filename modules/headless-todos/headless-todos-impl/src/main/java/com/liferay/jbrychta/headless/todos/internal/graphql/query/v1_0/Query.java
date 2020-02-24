package com.liferay.jbrychta.headless.todos.internal.graphql.query.v1_0;

import com.liferay.jbrychta.headless.todos.dto.v1_0.TodoItem;
import com.liferay.jbrychta.headless.todos.resource.v1_0.TodoItemResource;
import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLInvokeDetached;
import graphql.annotations.annotationTypes.GraphQLName;

import java.util.Collection;

import javax.annotation.Generated;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author Jan Brychta
 * @generated
 */
@Generated("")
public class Query {

	public static void setTodoItemResourceComponentServiceObjects(
		ComponentServiceObjects<TodoItemResource>
			todoItemResourceComponentServiceObjects) {

		_todoItemResourceComponentServiceObjects =
			todoItemResourceComponentServiceObjects;
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Collection<TodoItem> getTodosPage(
			@GraphQLName("search") String search,
			@GraphQLName("filter") Filter filter,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page, @GraphQLName("sorts") Sort[] sorts)
		throws Exception {

		return _applyComponentServiceObjects(
			_todoItemResourceComponentServiceObjects,
			this::_populateResourceContext,
			todoItemResource -> {
				Page paginationPage = todoItemResource.getTodosPage(
					search, filter, Pagination.of(pageSize, page), sorts);

				return paginationPage.getItems();
			});
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public TodoItem getTodoTodoItem(
			@GraphQLName("todoItemId") String todoItemId)
		throws Exception {

		return _applyComponentServiceObjects(
			_todoItemResourceComponentServiceObjects,
			this::_populateResourceContext,
			todoItemResource -> todoItemResource.getTodoTodoItem(todoItemId));
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

	private void _populateResourceContext(TodoItemResource todoItemResource)
		throws Exception {

		todoItemResource.setContextCompany(
			CompanyLocalServiceUtil.getCompany(
				CompanyThreadLocal.getCompanyId()));
	}

	private static ComponentServiceObjects<TodoItemResource>
		_todoItemResourceComponentServiceObjects;

}