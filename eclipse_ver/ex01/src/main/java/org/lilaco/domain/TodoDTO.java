package org.lilaco.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TodoDTO {

	private String title;
	
	// @InitBinder�� ����Ҷ�
	//private Date dueDate;
	
	// @DateTimeFormat���� �����ϱ�
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date dueDate;
}
