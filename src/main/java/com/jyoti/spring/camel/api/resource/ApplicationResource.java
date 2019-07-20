package com.jyoti.spring.camel.api.resource;

import org.apache.camel.BeanInject;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.jyoti.spring.camel.api.dto.Book;
import com.jyoti.spring.camel.api.process.RequestProcessor;
import com.jyoti.spring.camel.api.service.BookService;

@Component
public class ApplicationResource extends RouteBuilder {

	@Autowired
	private BookService service;

	@BeanInject
	private RequestProcessor processor;

	@Override
	public void configure() throws Exception {
		restConfiguration().component("servlet").port(3030).host("localhost").bindingMode(RestBindingMode.json);

		rest("/spring-boot-apache-camel-rest").get("/hello-world").produces(MediaType.APPLICATION_JSON_VALUE).route()
				.setBody(constant("Welcome to Apache camel")).endRest();

		// get All books
		rest("/spring-boot-apache-camel-rest").get("/book/all").produces(MediaType.APPLICATION_JSON_VALUE).route()
				.setBody(() -> service.getAllBooks());

		// Register a book
		rest("/spring-boot-apache-camel-rest").post("/book/add").consumes(MediaType.APPLICATION_JSON_VALUE)
				.type(Book.class).outType(Book.class).route().process(processor).endRest();

	}

}
