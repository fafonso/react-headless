package com.liferay.jbrychta.headless.todos.internal.resource.v1_0;


import com.liferay.jbrychta.headless.todos.dto.v1_0.TodoItem;
import com.liferay.jbrychta.headless.todos.resource.v1_0.TodoItemResource;
import com.liferay.portal.kernel.log.Log;

import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;
import todos.service.TodoItemService;

import javax.validation.constraints.NotNull;
import javax.ws.rs.PathParam;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jan Brychta
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/todo-item.properties",
	scope = ServiceScope.PROTOTYPE, service = TodoItemResource.class
)
public class TodoItemResourceImpl extends BaseTodoItemResourceImpl {

	@Override
	public Page<TodoItem> getTodosPage(Integer companyId, Integer groupId, String keywords, Filter filter, Pagination pagination, Sort[] sorts) throws Exception {

		List<todos.model.TodoItem> todoItemList = _todoItemService.searchTodoItemList(companyId.longValue(), groupId.longValue(), keywords, pagination.getStartPosition(), pagination.getEndPosition());
		long totalVitaminsCount = _todoItemService.getTodoItemListCount(companyId.longValue(), groupId.longValue(), keywords);

		List<TodoItem> result = new ArrayList<>();
		todoItemList.stream().forEach(v->{
			result.add(toDTO(v));
		});

		return Page.of(result, Pagination.of(pagination.getStartPosition(), pagination.getPageSize()), totalVitaminsCount);
	}

	@Override
	public TodoItem postTodo(TodoItem todoItem) throws Exception {
		todos.model.TodoItem serviceTodoItem = null;
		if(todoItem.getId() == null || todoItem.getId() <=0){
			serviceTodoItem =
					_todoItemService.
							addTodoItem(todoItem.getCompanyId().longValue(), todoItem.getGroupId().longValue(), todoItem.getName(), todoItem.getDescription());
		}else{
			serviceTodoItem =
					_todoItemService.updateTodoItem(todoItem.getId().longValue() , todoItem.getCompanyId().longValue(), todoItem.getGroupId().longValue(), todoItem.getName(), todoItem.getDescription());
		}


		return toDTO(serviceTodoItem);
	}

	@Override
	public TodoItem getTodoTodoItem(Integer todoItemId)
			throws Exception {

		todos.model.TodoItem serviceTodoItem = _todoItemService.getTodoItem(todoItemId.longValue());

		return toDTO(serviceTodoItem);
	}

	@Override
	public TodoItem deleteTodoTodoItem(@NotNull Integer todoItemId) throws Exception {

		todos.model.TodoItem todoItem = _todoItemService.deleteTodoItem(todoItemId);

		return toDTO(todoItem);
	}

	private TodoItem toDTO(todos.model.TodoItem serviceTodoItem){
		TodoItem result = new TodoItem();
		result.setId((int)serviceTodoItem.getTodoItemId());
		result.setName(serviceTodoItem.getName());
		result.setDescription(serviceTodoItem.getDescription());
		result.setCompanyId((int)serviceTodoItem.getCompanyId());
		result.setGroupId((int)serviceTodoItem.getGroupId());

		return result;
	}

	@Reference
	private TodoItemService _todoItemService;

	private Log _log = LogFactoryUtil.getLog(TodoItemResourceImpl.class.getName());

}