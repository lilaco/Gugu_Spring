package org.lilaco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/sample/*")
@Slf4j
public class SampleController {
	
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
}
