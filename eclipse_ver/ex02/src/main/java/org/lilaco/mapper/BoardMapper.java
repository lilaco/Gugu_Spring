package org.lilaco.mapper;

import java.util.List;

//import org.apache.ibatis.annotations.Select;
import org.lilaco.domain.BoardVO;

public interface BoardMapper {

	//XML에 SQL문을 처리했기때문에 Select Annotation을 주석처리.
	//@Select("select * from tbl_board where bno > 0")
	public List<BoardVO> getList();
	
}
