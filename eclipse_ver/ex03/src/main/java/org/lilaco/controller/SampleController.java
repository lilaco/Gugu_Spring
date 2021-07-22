package org.lilaco.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.lilaco.domain.SampleVO;
import org.lilaco.domain.Ticket;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/sample")
@Slf4j
public class SampleController {

	@GetMapping(value= "/getText", produces = "text/plain; charset=UTF-8")
	public String getText() {
		log.info("MIME TYPE: " + MediaType.TEXT_PLAIN_VALUE);
		
		return "�ȳ��ϼ���";
	}
	
	@GetMapping(value= "/getSample", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE })
	public SampleVO getSample() {
		return new SampleVO(112, "��Ÿ", "�ε�");
	}
	
	// GetMapping�̳� RequestMapping�� produces �Ӽ��� �ݵ�� �����ؾ� �ϴ� ���� �ƴϹǷ� �����ϴ� �͵� �����ϴ�.
	@GetMapping(value= "/getSample2")
	public SampleVO getSample2() {
		return new SampleVO(113, "����", "����");
	}
	
	// ��쿡 ���󼭴� ���� �����͸� �� ���� �����ϱ� ���ؼ� �迭�̳� ����Ʈ, �� Ÿ���� ��ü���� �����ϴ� ��쵵 �߻��Ѵ�.
	@GetMapping(value = "/getList")
	public List<SampleVO> getList() {
		return IntStream.range(1, 10).mapToObj(i -> new SampleVO(i, i + "First", i + " Last")).collect(Collectors.toList());
	}
	
	// �� Ÿ�� ��ü ����.
	@GetMapping(value = "/getMap")
	public Map<String, SampleVO> getMap() {
		
		Map<String, SampleVO> map = new HashMap<>();
		map.put("First", new SampleVO(111, "�׷�Ʈ", "�ִϾ�"));
		
		return map;
	}
	
	// ResponseEntity Ÿ��
	// �����Ϳ� �Բ� HTTP ����� ���� �޽��� ���� ���� �����ϴ� �뵵.
	@GetMapping(value = "/check", params = {"height", "weight"})
	public ResponseEntity<SampleVO> check(Double height, Double weight) {
		
		SampleVO vo = new SampleVO(0, "" + height, "" + weight);
		
		ResponseEntity<SampleVO> result = null;
		
		if (height < 150) {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		} else {
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
		}
		
		return result;
	}
	
	// @PathVariable
	// @PathVariable�� �ش��ϴ� URL �ּҿ� ���� �Է��ϸ� cat�� pid ������ ������ ó����.
	@GetMapping("/product/{cat}/{pid}")
	public String[] getPath(@PathVariable("cat") String cat, @PathVariable("pid") Integer pid) {
		
		return new String[] { "category: " + cat, "productid: " + pid };
	}
	
	// Ticket�� ����ϴ� ������ SampleController�� �߰�.
	// �ٸ� �޼���� 3�޸� @PostMapping�� ����� ������ @RequestBody�� �� �״�� ��û(request)�� ����(body)�� ó���ϱ� ������
	// �Ϲ����� �Ķ���� ���޹���� ����� �� ����.
	@PostMapping("/ticket")
	public Ticket convert(@RequestBody Ticket ticket) {//JSON���� ���޵Ǵ� �����͸� �޾Ƽ� Ticket Ÿ������ ��ȯ.
		
		log.info("convert.......ticket" + ticket);
		
		return ticket;
	}
			
	
}