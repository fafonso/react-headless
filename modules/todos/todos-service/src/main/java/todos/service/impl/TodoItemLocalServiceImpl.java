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

package todos.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.*;
import com.liferay.portal.kernel.util.GetterUtil;
import org.osgi.service.component.annotations.Component;
import todos.model.TodoItem;
import todos.service.base.TodoItemLocalServiceBaseImpl;
import todos.service.search.TodoItemIndexer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The implementation of the todo item local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>todos.service.TodoItemLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TodoItemLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=todos.model.TodoItem",
	service = AopService.class
)
public class TodoItemLocalServiceImpl extends TodoItemLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>todos.service.TodoItemLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>todos.service.TodoItemLocalServiceUtil</code>.
	 */

	/**
	 *
	 *
	 * Use TodoItem addTodoItem(long companyId, long groupId, String name, String description) instead.
	 * @param todoItem the todo item
	 * @return
	 */
	@Override
	public TodoItem addTodoItem(TodoItem todoItem) {
		throw new UnsupportedOperationException();
	}

	@Indexable(
			type = IndexableType.REINDEX
	)
	@Override
	public TodoItem addTodoItem(long companyId, long groupId, String name, String description){

		//TODO: validation

		long todoItemId = counterLocalService.increment(TodoItem.class.getName());

		TodoItem todoItem = createTodoItem(todoItemId);

		todoItem.setCompanyId(companyId);
		todoItem.setGroupId(groupId);
		todoItem.setName(name);
		todoItem.setDescription(description);

		todoItem.setCreateDate(new Date());
		todoItem.setModifiedDate(new Date());

		todoItem = super.addTodoItem(todoItem);

		return todoItem;
	}

	@Indexable(
			type = IndexableType.REINDEX
	)
	@Override
	public TodoItem updateTodoItem(long todoItemId, long companyId, long groupId, String name, String description){

		//TODO: validation

		TodoItem todoItem = super.fetchTodoItem(todoItemId);
		if(todoItem == null){
			throw new IllegalArgumentException("There is no item for id= " + todoItemId);
		}

		todoItem.setCompanyId(companyId);
		todoItem.setGroupId(groupId);
		todoItem.setName(name);
		todoItem.setDescription(description);

		todoItem.setModifiedDate(new Date());

		todoItem = super.updateTodoItem(todoItem);

		return todoItem;
	}

	@Override
	@Indexable(
			type = IndexableType.DELETE
	)
	public TodoItem deleteTodoItem(long todoItemId){

		TodoItem todoItem = super.fetchTodoItem(todoItemId);
		if(todoItem == null){
			throw new IllegalArgumentException("There is no item for id= " + todoItemId);
		}

		todoItem = super.deleteTodoItem(todoItem);

		return todoItem;
	}

	public List<TodoItem> getTodoItemList(long companyId, long groupId, String keywords, int start, int end){
		return todoItemPersistence.findByCompanyIdGroupId(companyId, groupId, start, end);
	}

	public int getTodoItemListCount(long companyId, long groupId, String keywords){
		return todoItemPersistence.countByCompanyIdGroupId(companyId, groupId);
	}

	public List<TodoItem> searchTodoItemList(long companyId, long groupId, String keywords, int start, int end){
		
		List<TodoItem> result = new ArrayList<>();
		
		Indexer<TodoItem> indexer = IndexerRegistryUtil.nullSafeGetIndexer(TodoItem.class);

		SearchContext searchContext = new SearchContext();
		searchContext.setAndSearch(true);
		searchContext.setCompanyId(companyId);
		searchContext.setGroupIds(new long[] {groupId});
		searchContext.setStart(start);
		searchContext.setEnd(end);
		searchContext.setKeywords(keywords);
		
		try {
			Hits searchHits = indexer.search(searchContext);
			List<Document> documents = searchHits.toList();
			if(documents == null || documents.size() <= 0){
				_log.error("EMPTY");
			}else{
				for (Document doc :
						documents) {
					long todoItemId = GetterUtil.getLong(doc.get(TodoItemIndexer.FIELDS.TODO_ITEM_ID));

					TodoItem todoItem = fetchTodoItem(todoItemId);
					if(todoItem == null){
						indexer.delete(companyId, doc.getUID());
					}else {
						result.add(todoItem);
					}
				}
			}
		}catch (SearchException s){
			_log.error("Search", s);
		}
		
		return result;
	}

	private Log _log = LogFactoryUtil.getLog(TodoItemLocalServiceImpl.class.getName());

}