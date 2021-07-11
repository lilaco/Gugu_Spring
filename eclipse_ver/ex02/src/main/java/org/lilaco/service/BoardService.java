package org.lilaco.service;

import java.util.List;

import org.lilaco.domain.BoardVO;

public interface BoardService {
	// create
	public void register(BoardVO board);
	
	// read
	public BoardVO get(Long bno);
	
	// update
	public boolean modify(BoardVO board);
	
	// delete
	public boolean remove(Long bno);
	
	// list
	public List<BoardVO> getList();
}
