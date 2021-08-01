package org.lilaco.service;

import java.util.List;

import org.lilaco.domain.Criteria;
import org.lilaco.domain.ReplyVO;
import org.lilaco.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ReplyServiceImpl implements ReplyService{
	
//	@Setter(onMethod_ = @Autowired)
//	private ReplyMapper mapper;
	
	// Spring 4.3부터는 생성자와 자동주입을 이용하여 아래와 같이 처리 가능
	private ReplyMapper mapper;
	
	@Override
	public int register(ReplyVO replyVO) {
		
		log.info("register....." + replyVO);
		return mapper.insert(replyVO);
	}

	@Override
	public ReplyVO get(Long rno) {
		
		log.info("get....." + rno);
		return mapper.read(rno);
	}

	@Override
	public int modify(ReplyVO replyVO) {
		
		log.info("modify....." + replyVO);
		return mapper.update(replyVO);
	}

	@Override
	public int remove(Long rno) {
		
		log.info("remove...." + rno);
		return mapper.delete(rno);
	}

	@Override
	public List<ReplyVO> getList(Criteria cri, Long bno) {
		
		log.info("get Reply List of a Board " + bno);
		return mapper.getListWithPaging(cri, bno);
	}

}
