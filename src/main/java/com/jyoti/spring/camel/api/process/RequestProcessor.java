package com.jyoti.spring.camel.api.process;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jyoti.spring.camel.api.dto.Book;
import com.jyoti.spring.camel.api.service.BookService;

@Component
public class RequestProcessor  implements Processor{

	@Autowired
	private BookService service;
	
	@Override
	public void process(Exchange exchange) throws Exception {
		service.addBook(exchange.getIn().getBody(Book.class));
		
	}

}
