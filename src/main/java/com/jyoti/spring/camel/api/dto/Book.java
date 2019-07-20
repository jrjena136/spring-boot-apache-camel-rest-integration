package com.jyoti.spring.camel.api.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book implements Serializable{

	private static final long serialVersionUID = 1L;

	private String author;
	private String bookName;
	@JsonFormat(locale = "en", timezone = "IST", shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss a")
	private Date publishedDate;

}
