package org.lilaco.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.lilaco.domain.Criteria;
import org.lilaco.domain.ReplyVO;

public interface ReplyMapper {

	// 외래키를 사용하는 Create
	public int insert(ReplyVO replyVO);
	
	// Read
	public ReplyVO read(Long rno);
	
	// Delete
	public int delete (Long rno);
	
	// Update
	public int update (ReplyVO replyVO);
	
	// LIST with pagination
	public List<ReplyVO> getListWithPaging(@Param("cri") Criteria cri, @Param("bno") Long bno);

}
