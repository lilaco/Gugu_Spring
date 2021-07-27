package org.lilaco.mapper;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lilaco.domain.Criteria;
import org.lilaco.domain.ReplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {

	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;
	
	// ReplyMapper 타입의 객체가 정상적으로 사용 가능한지 확인
	@Test
	public void testMapper() {
		log.info(mapper);
	}
	
	//댓글 Insert Test
	// 테스트 전에 해당 번호의 게시물이 존재하는지 반드시 확인할 것
	private Long[] bnoArr = { 36L, 35L, 33L, 32L, 31L };
	
	@Test
	public void testCreate() {
		
		IntStream.rangeClosed(1, 10).forEach(i -> {
			
			ReplyVO replyVO = new ReplyVO();
			
			//게시물의 번호
			replyVO.setBno(bnoArr[i % 5]);
			replyVO.setReply("댓글 테스트 " + i);
			replyVO.setReplyer("댓글러" + i);
			
			mapper.insert(replyVO);
		});
	}
	
	// Read Test
	@Test
	public void testRead() {
		
		Long targetRno = 5L;
		ReplyVO replyVO = mapper.read(targetRno);
		
		log.info(replyVO);
	}
	
	// Delete Test
	@Test
	public void testDelete() {
		
		Long targetRno = 10L;
		
		mapper.delete(targetRno);
	}
	
	// Update Test
	@Test
	public void testUpdate() {
		Long targetRno = 9L;
		
		ReplyVO replyVO = mapper.read(targetRno);
		
		replyVO.setReply("Update Reply ");
		
		int count = mapper.update(replyVO);
		
		log.info("UPDATE COUNT: " + count);
	}
	
	// List with pagination Test
	@Test
	public void testList() {
		Criteria cri = new Criteria();
		//bno 36L과 매칭
		List<ReplyVO> replies = mapper.getListWithPaging(cri, bnoArr[0]);
		
		replies.forEach(reply -> log.info(reply));
	}
	
	
}
