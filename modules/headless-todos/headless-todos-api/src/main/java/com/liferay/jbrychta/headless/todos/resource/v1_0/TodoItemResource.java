package com.liferay.jbrychta.headless.todos.resource.v1_0;

import com.liferay.jbrychta.headless.todos.dto.v1_0.TodoItem;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import javax.annotation.Generated;

/**
 * To access this resource, run:
 *
 *     curl -u your@email.com:yourpassword -D - http://localhost:8080/o/headless-todos/v1.0
 *
 * @author Jan Brychta
 * @generated
 */
@Generated("")
public interface TodoItemResource {

	public Page<TodoItem> getTodosPage(
			Integer companyId, Integer groupId, String keywords, Filter filter,
			Pagination pagination, Sort[] sorts)
		throws Exception;

	public TodoItem postTodo(TodoItem todoItem) throws Exception;

	public TodoItem deleteTodoTodoItem(Integer todoItemId) throws Exception;

	public TodoItem getTodoTodoItem(Integer todoItemId) throws Exception;

	public TodoItem putTodoTodoItem(String todoItemId, TodoItem todoItem)
		throws Exception;

	public void setContextCompany(Company contextCompany);

}