package org.lilaco.service;

import java.util.List;

import org.lilaco.domain.Criteria;
import org.lilaco.domain.ReplyVO;

public interface ReplyService {

	public int register(ReplyVO replyVO);
	
	public ReplyVO get(Long rno);
	
	public int modify(ReplyVO replyVO);
	
	public int remove(Long rno);
	
	public List<ReplyVO> getList(Criteria cri, Long bno);
}
