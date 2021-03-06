package com.encore.board.model;

import java.util.List;

import com.encore.board.domain.BoardVO;

public interface BoardDAO {
	int write(BoardVO vo);
	String selectByNoForDate(int no);
	List<BoardVO> getBoardList();
	BoardVO showContent(int no);
	int clickCount(int no);
	int delete(int no);
	int update(BoardVO vo);
}
