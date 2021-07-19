package org.lilaco.mapper;

import java.util.List;

//import org.apache.ibatis.annotations.Select;
import org.lilaco.domain.BoardVO;
import org.lilaco.domain.Criteria;

public interface BoardMapper {

	//XML에 SQL문을 처리했기때문에 Select Annotation을 주석처리.
	//@Select("select * from tbl_board where bno > 0")
	public List<BoardVO> getList();
	
	// Pagination을 위한 리스트 처리
	public List<BoardVO> getListWithPaging(Criteria cri);
	
	// insert만 처리되고 생성된 PK 값을 알 필요가 없는 경우
	public void insert(BoardVO board);
	
	// insert문이 실행되고 생성된 PK 값을 알아야 하는 경우
	public void insertSelectKey(BoardVO board);
	
	// read 처리
	public BoardVO read(Long bno);
	
	// delete 처리
	public int delete(Long bno);
	
	// update 처리
	public int update(BoardVO board);
	
	// totalcount
	public int getTotalCount(Criteria cri);
}
