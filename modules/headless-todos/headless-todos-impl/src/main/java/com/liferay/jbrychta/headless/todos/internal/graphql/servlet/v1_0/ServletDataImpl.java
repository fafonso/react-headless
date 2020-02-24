package com.liferay.jbrychta.headless.todos.internal.graphql.servlet.v1_0;

import com.liferay.jbrychta.headless.todos.internal.graphql.mutation.v1_0.Mutation;
import com.liferay.jbrychta.headless.todos.internal.graphql.query.v1_0.Query;
import com.liferay.jbrychta.headless.todos.resource.v1_0.TodoItemResource;
import com.liferay.portal.vulcan.graphql.servlet.ServletData;

import javax.annotation.Generated;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentServiceObjects;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceScope;

/**
 * @author Jan Brychta
 * @generated
 */
@Component(immediate = true, service = ServletData.class)
@Generated("")
public class ServletDataImpl implements ServletData {

	@Activate
	public void activate(BundleContext bundleContext) {
		Mutation.setTodoItemResourceComponentServiceObjects(
			_todoItemResourceComponentServiceObjects);

		Query.setTodoItemResourceComponentServiceObjects(
			_todoItemResourceComponentServiceObjects);
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/headless-todos-graphql/v1_0";
	}

	@Override
	public Query getQuery() {
		return new Query();
	}

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<TodoItemResource>
		_todoItemResourceComponentServiceObjects;

}