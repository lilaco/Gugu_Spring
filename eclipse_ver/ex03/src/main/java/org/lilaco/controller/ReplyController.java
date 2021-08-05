package org.lilaco.controller;

import java.util.List;

import org.lilaco.domain.Criteria;
import org.lilaco.domain.ReplyVO;
import org.lilaco.service.ReplyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/replies/")
@RestController
@Slf4j
@AllArgsConstructor
public class ReplyController {

	private ReplyService replyService;
	
	@PostMapping(value = "/new",
			consumes = "application/json",
			produces = { MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> create(@RequestBody ReplyVO replyVO) {
		log.info("ReplyVO: " + replyVO);
		
		int insertCount = replyService.register(replyVO);
		
		log.info("Reply INSERT COUNT: " + insertCount);
		
		return insertCount == 1 ? new ResponseEntity<>("success", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value = "/pages/{bno}/{page}", produces= {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<ReplyVO>> getList(@PathVariable("page") int page, @PathVariable("bno") Long bno) {
		
		log.info("get List..................");
		Criteria cri = new Criteria(page,10);
		log.info(""+cri);
		
		return new ResponseEntity<>(replyService.getList(cri, bno), HttpStatus.OK);
	}
	
	// 댓글 조회/삭제/수정
	@GetMapping(value = "/{rno}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<ReplyVO> get(@PathVariable("rno") Long rno) {
		
		log.info("get: " + rno);
		
		return new ResponseEntity<>(replyService.get(rno), HttpStatus.OK);
	}
	
	@DeleteMapping(value= "/{rno}", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remove(@PathVariable("rno") Long rno) {
		
		log.info("remove: " + rno);
		
		return replyService.remove(rno) == 1 
				? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// 실제 수정되는 데이터는 JSON 포맷이므로 @RequestBody를 이용해서 처리한다.
	@RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH}, value="/{rno}", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> modify(@RequestBody ReplyVO replyVO, @PathVariable("rno") Long rno) {
		
		replyVO.setRno(rno);
		
		log.info("rno: " + rno);
		log.info("modify: " + replyVO);
		
		return replyService.modify(replyVO) == 1
				? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
