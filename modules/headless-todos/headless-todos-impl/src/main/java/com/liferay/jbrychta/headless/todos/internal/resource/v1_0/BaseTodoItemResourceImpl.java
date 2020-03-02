package com.liferay.jbrychta.headless.todos.internal.resource.v1_0;

import com.liferay.jbrychta.headless.todos.dto.v1_0.TodoItem;
import com.liferay.jbrychta.headless.todos.resource.v1_0.TodoItemResource;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.util.TransformUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.annotation.Generated;

import javax.validation.constraints.NotNull;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * @author Jan Brychta
 * @generated
 */
@Generated("")
@Path("/v1.0")
public abstract class BaseTodoItemResourceImpl implements TodoItemResource {

	@Override
	@GET
	@Operation(
		description = "Retrieves the list of todo items. Results can be paginated, filtered, searched, and sorted."
	)
	@Parameters(
		value = {
			@Parameter(in = ParameterIn.QUERY, name = "companyId"),
			@Parameter(in = ParameterIn.QUERY, name = "groupId"),
			@Parameter(in = ParameterIn.QUERY, name = "keywords"),
			@Parameter(in = ParameterIn.QUERY, name = "filter"),
			@Parameter(in = ParameterIn.QUERY, name = "page"),
			@Parameter(in = ParameterIn.QUERY, name = "pageSize"),
			@Parameter(in = ParameterIn.QUERY, name = "sort")
		}
	)
	@Path("/todos")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "TodoItem")})
	public Page<TodoItem> getTodosPage(
			@Parameter(hidden = true) @QueryParam("companyId") Integer
				companyId,
			@Parameter(hidden = true) @QueryParam("groupId") Integer groupId,
			@Parameter(hidden = true) @QueryParam("keywords") String keywords,
			@Context Filter filter, @Context Pagination pagination,
			@Context Sort[] sorts)
		throws Exception {

		return Page.of(Collections.emptyList());
	}

	@Override
	@Consumes({"application/json", "application/xml"})
	@Operation(description = "Create a new todo item.")
	@POST
	@Path("/todos")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "TodoItem")})
	public TodoItem postTodo(TodoItem todoItem) throws Exception {
		return new TodoItem();
	}

	@Override
	@DELETE
	@Operation(
		description = "Deletes the todoItem and returns a 204 if the operation succeeds."
	)
	@Parameters(
		value = {@Parameter(in = ParameterIn.PATH, name = "todoItemId")}
	)
	@Path("/todos/{todoItemId}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "TodoItem")})
	public TodoItem deleteTodoTodoItem(
			@NotNull @Parameter(hidden = true) @PathParam("todoItemId") Integer
				todoItemId)
		throws Exception {

		return new TodoItem();
	}

	@Override
	@GET
	@Operation(description = "Retrieves the todo item by its ID.")
	@Parameters(
		value = {@Parameter(in = ParameterIn.PATH, name = "todoItemId")}
	)
	@Path("/todos/{todoItemId}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "TodoItem")})
	public TodoItem getTodoTodoItem(
			@NotNull @Parameter(hidden = true) @PathParam("todoItemId") Integer
				todoItemId)
		throws Exception {

		return new TodoItem();
	}

	@Override
	@Consumes({"application/json", "application/xml"})
	@Operation(
		description = "Replaces the todo item with the information sent in the request body. Any missing fields are deleted, unless they are required."
	)
	@PUT
	@Parameters(
		value = {@Parameter(in = ParameterIn.PATH, name = "todoItemId")}
	)
	@Path("/todos/{todoItemId}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "TodoItem")})
	public TodoItem putTodoTodoItem(
			@NotNull @Parameter(hidden = true) @PathParam("todoItemId") String
				todoItemId,
			TodoItem todoItem)
		throws Exception {

		return new TodoItem();
	}

	public void setContextCompany(Company contextCompany) {
		this.contextCompany = contextCompany;
	}

	protected void preparePatch(TodoItem todoItem, TodoItem existingTodoItem) {
	}

	protected <T, R> List<R> transform(
		Collection<T> collection,
		UnsafeFunction<T, R, Exception> unsafeFunction) {

		return TransformUtil.transform(collection, unsafeFunction);
	}

	protected <T, R> R[] transform(
		T[] array, UnsafeFunction<T, R, Exception> unsafeFunction,
		Class<?> clazz) {

		return TransformUtil.transform(array, unsafeFunction, clazz);
	}

	protected <T, R> R[] transformToArray(
		Collection<T> collection,
		UnsafeFunction<T, R, Exception> unsafeFunction, Class<?> clazz) {

		return TransformUtil.transformToArray(
			collection, unsafeFunction, clazz);
	}

	protected <T, R> List<R> transformToList(
		T[] array, UnsafeFunction<T, R, Exception> unsafeFunction) {

		return TransformUtil.transformToList(array, unsafeFunction);
	}

	@Context
	protected AcceptLanguage contextAcceptLanguage;

	@Context
	protected Company contextCompany;

	@Context
	protected UriInfo contextUriInfo;

}