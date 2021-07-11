package org.lilaco.mapper;

import java.util.List;

//import org.apache.ibatis.annotations.Select;
import org.lilaco.domain.BoardVO;

public interface BoardMapper {

	//XML�� SQL���� ó���߱⶧���� Select Annotation�� �ּ�ó��.
	//@Select("select * from tbl_board where bno > 0")
	public List<BoardVO> getList();
	
	// insert�� ó���ǰ� ������ PK ���� �� �ʿ䰡 ���� ���
	public void insert(BoardVO board);
	
	// insert���� ����ǰ� ������ PK ���� �˾ƾ� �ϴ� ���
	public void insertSelectKey(BoardVO board);
	
	// read ó��
	public BoardVO read(Long bno);
	
	// delete ó��
	public int delete(Long bno);
	
	// update ó��
	public int update(BoardVO board);
}