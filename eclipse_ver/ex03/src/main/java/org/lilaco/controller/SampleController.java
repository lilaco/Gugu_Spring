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
		
		return "안녕하세요";
	}
	
	@GetMapping(value= "/getSample", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE })
	public SampleVO getSample() {
		return new SampleVO(112, "스타", "로드");
	}
	
	// GetMapping이나 RequestMapping의 produces 속성은 반드시 지정해야 하는 것은 아니므로 생략하는 것도 가능하다.
	@GetMapping(value= "/getSample2")
	public SampleVO getSample2() {
		return new SampleVO(113, "로켓", "라쿤");
	}
	
	// 경우에 따라서는 여러 데이터를 한 번에 전송하기 위해서 배열이나 리스트, 맵 타입의 객체들을 전송하는 경우도 발생한다.
	@GetMapping(value = "/getList")
	public List<SampleVO> getList() {
		return IntStream.range(1, 10).mapToObj(i -> new SampleVO(i, i + "First", i + " Last")).collect(Collectors.toList());
	}
	
	// 맵 타입 객체 전송.
	@GetMapping(value = "/getMap")
	public Map<String, SampleVO> getMap() {
		
		Map<String, SampleVO> map = new HashMap<>();
		map.put("First", new SampleVO(111, "그루트", "주니어"));
		
		return map;
	}
	
	// ResponseEntity 타입
	// 데이터와 함께 HTTP 헤더의 상태 메시지 등을 같이 전달하는 용도.
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
	// @PathVariable에 해당하는 URL 주소에 값을 입력하면 cat과 pid 변수의 값으로 처리됨.
	@GetMapping("/product/{cat}/{pid}")
	public String[] getPath(@PathVariable("cat") String cat, @PathVariable("pid") Integer pid) {
		
		return new String[] { "category: " + cat, "productid: " + pid };
	}
	
	// Ticket을 사용하는 예제는 SampleController에 추가.
	// 다른 메서드와 3달리 @PostMapping이 적용된 이유는 @RequestBody가 말 그대로 요청(request)한 내용(body)를 처리하기 때문에
	// 일반적인 파라미터 전달방식을 사용할 수 없다.
	@PostMapping("/ticket")
	public Ticket convert(@RequestBody Ticket ticket) {
		
		log.info("convert.......ticket" + ticket);
		
		return ticket;
	}
			
	
}
