package com.liferay.jbrychta.headless.todos.internal.resource.v1_0;

import com.liferay.jbrychta.headless.todos.dto.v1_0.TodoItem;
import com.liferay.jbrychta.headless.todos.resource.v1_0.TodoItemResource;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactory;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

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
	public Page<TodoItem> getTodosPage(String search, Filter filter, Pagination pagination, Sort[] sorts) throws Exception {

		List<TodoItem> vitamins = mockResult(pagination.getStartPosition(), pagination.getPageSize(), search);
		long totalVitaminsCount = 100;

		// write code here, should add to the list of Vitamin objects

		return Page.of(vitamins, Pagination.of(pagination.getStartPosition(), pagination.getPageSize()), totalVitaminsCount);
	}

	private List<TodoItem> mockResult(int start, int delta, String search){
		_log.error("SEARCH:" + search);
		_log.error("START:" + start);
		_log.error("DELTA:" + delta);

		List<TodoItem> result = new ArrayList<>();
		int count = 0;
		for (int i=0; i<100; i++){
			if(i>=start){
				if(count < delta){
					count ++;
					TodoItem todoItem = new TodoItem();
					todoItem.setId(String.valueOf(i));
					todoItem.setName("name" + i);
					result.add(todoItem);
				}
			}
		}

		return result;
	}

	private Log _log = LogFactoryUtil.getLog(TodoItemResourceImpl.class.getName());

}