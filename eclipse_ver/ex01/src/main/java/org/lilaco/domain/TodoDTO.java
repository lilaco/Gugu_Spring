package org.lilaco.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TodoDTO {

	private String title;
	
	// @InitBinder를 사용할때
	//private Date dueDate;
	
	// @DateTimeFormat으로 구현하기
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date dueDate;
}
