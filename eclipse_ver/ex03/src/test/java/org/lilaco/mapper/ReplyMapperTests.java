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
	
	// ReplyMapper Ÿ���� ��ü�� ���������� ��� �������� Ȯ��
	@Test
	public void testMapper() {
		log.info(mapper);
	}
	
	//��� Insert Test
	// �׽�Ʈ ���� �ش� ��ȣ�� �Խù��� �����ϴ��� �ݵ�� Ȯ���� ��
	private Long[] bnoArr = { 36L, 35L, 33L, 32L, 31L };
	
	@Test
	public void testCreate() {
		
		IntStream.rangeClosed(1, 10).forEach(i -> {
			
			ReplyVO replyVO = new ReplyVO();
			
			//�Խù��� ��ȣ
			replyVO.setBno(bnoArr[i % 5]);
			replyVO.setReply("��� �׽�Ʈ " + i);
			replyVO.setReplyer("��۷�" + i);
			
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
		//bno 36L�� ��Ī
		List<ReplyVO> replies = mapper.getListWithPaging(cri, bnoArr[0]);
		
		replies.forEach(reply -> log.info(reply));
	}
	
	
}
