package org.lilaco.mapper;

import java.util.List;

//import org.apache.ibatis.annotations.Select;
import org.lilaco.domain.BoardVO;

public interface BoardMapper {

	//XML�� SQL���� ó���߱⶧���� Select Annotation�� �ּ�ó��.
	//@Select("select * from tbl_board where bno > 0")
	public List<BoardVO> getList();
	
}
