package com.liferay.jbrychta.headless.todos.internal.jaxrs.application;

import javax.annotation.Generated;

import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;

/**
 * @author Jan Brychta
 * @generated
 */
@Component(
	property = {
		"osgi.jaxrs.application.base=/headless-todos",
		"osgi.jaxrs.extension.select=(osgi.jaxrs.name=Liferay.Vulcan)",
		"osgi.jaxrs.name=jbrychta.Headless.Todos"
	},
	service = Application.class
)
@Generated("")
public class HeadlessTodosApplication extends Application {
}