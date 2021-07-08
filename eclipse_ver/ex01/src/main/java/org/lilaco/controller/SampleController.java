package org.lilaco.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.lilaco.domain.SampleDTO;
import org.lilaco.domain.SampleDTOList;
import org.lilaco.domain.TodoDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/sample/*")
@Slf4j
public class SampleController {
	
	//�Ķ���͸� �޾Ƽ� ��ȯó���Ҷ� ����ϴ� Annotation. ref)ex03
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
//	}
	
	@RequestMapping("")
	public void basic() {
		log.info("basic..........");
	}
	
	// GET, POST ��� �����ؾ� �ϴ� ��쿡 �迭�� ó���ؼ� ������ �� �ִ�.
	@RequestMapping(value = "/basic", method = {RequestMethod.GET, RequestMethod.POST})
	public void basicGet() {
		log.info("basic get...................");
	}
	
	@GetMapping("/basicOnlyGet")
	public void basicGet2() {
		log.info("basic get only get................");
	}
	
	// http://localhost:8080/sample/ex01?name=AAA&age=29
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		log.info("" + dto);
		
		return "ex01";
	}
	
	// http://localhost:8080/sample/ex02?name=BBB&age=19
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
		log.info("name: " + name);
		log.info("age: " + age) ;
		
		return "ex02";
	}
	
	// http://localhost:8080/sample/ex02List?ids=1111&ids=2222&ids=3333
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids")ArrayList<String> ids) {
		log.info("ids: " + ids);
		
		return "ex02List";
	}
	
	// http://localhost:8080/sample/ex02Array?ids=1111&ids=2222&ids=3333
	@GetMapping("/ex02Array")
	public String ex02Array(@RequestParam("ids") String[] ids) {
		log.info("array ids: " + Arrays.toString(ids));
		
		return "ex02Array";
	}
	
	// http://localhost:8080/sample/ex02Bean?list%5B0%5D.name=aaa&list%5B2%5D.name=bbb&list%5B2%5D.name=ccc
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {
		log.info("list dtos: " + list);
		
		return "ex02Bean";
	}
	
	// http://localhost:8080/sample/ex03?title=test&dueDate=2021-11-29
	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {
		log.info("todo: " + todo);
		return "ex03";
	}
	
	// http://localhost:8080/sample/ex04?name=aaa&age=11&page=9
	// int(�⺻�ڷ���)�� ȭ�鿡 ���޵��� �ʴ´�.
//	@GetMapping("/ex04")
//	public String ex04(SampleDTO dto, int page) {
//		log.info("dto: " + dto);
//		log.info("page: " + page);
//		
//		return "/sample/ex04";
//	}
	
	// @ModelAttribute�� ����Ͽ� �⺻�ڷ����� ȭ�鿡 ���.
	// http://localhost:8080/sample/ex04?name=aaa&age=11&page=9
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {
		log.info("dto: " + dto);
		log.info("page" + page);
		
		return "/sample/ex04";
	}
	
	// VOID Ÿ�� Controller
	// http://localhost:8080/sample/ex05
	@GetMapping("/ex05")
	public void ex05() {
		log.info("/ex05......");
	}
	
	// VO, DTO Ÿ�� Controller
	// JSON ��ü�� ��ȯ��.
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		log.info("/ex06.........");
		
		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("ȫ�浿");
		
		return dto;
	}
	
	//ResponseEntity Ÿ�� Controller
	// HTTP Header �޼����� �����Ѵ�.
	@GetMapping("/ex07")
	public ResponseEntity<String> ex07() {
		log.info("/ex07.............");
		
		// {"name": "ȫ�浿"}
		String msg = "{\"name\": \"ȫ�浿\"}";
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
		
		return new ResponseEntity<>(msg, header, HttpStatus.OK);
	}
	
	// get ������� ������ ���ε��� ȭ���� ó��
	@GetMapping("/exUpload")
	public void exUpload() {
		log.info("/exUpload...........");
	}
	
	// ���� ���ε� POST MAPPING.�α׷� Ȯ�θ� �ϱ�
	@PostMapping("/exUploadPost")
	public void exUploadPost(ArrayList<MultipartFile> files) {
		files.forEach(file -> {
			log.info("-------------------------------");
			log.info("name: " + file.getOriginalFilename());
			log.info("size: " + file.getSize());
			
		});
	}
}
