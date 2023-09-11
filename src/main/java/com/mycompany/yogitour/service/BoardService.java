package com.mycompany.yogitour.service;

import java.util.List;

import com.mycompany.yogitour.dto.Board;
import com.mycompany.yogitour.dto.Pager;

public interface BoardService {
	public void write(Board board);
	public void remove(int bno);
	public void modify(Board board);
	public List<Board> getList();
	public Board getBoard(int bno);
	public Board getBoardOnlyAttachData(int bno);
	public void addHitCount(int bno);
	public int getTotalBoardNum();
}
