package com.mycompany.yogitour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.yogitour.dao.BoardDao;
import com.mycompany.yogitour.dto.Board;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public void write(Board board) {
		boardDao.insert(board);
	}
	
	@Override
	public void remove(int bno) {
		boardDao.deleteByBno(bno);
	}
	
	@Override
	public void modify(Board board) {
		Board dbBoard = boardDao.selectByBno(board.getBno());
		boardDao.updateByBno(dbBoard);
	}
	
	@Override
	public List<Board> getList() {
		List<Board> boardList = boardDao.selectAll();
		return boardList;
	}
	
	@Override
	public Board getBoard(int bno) {
		Board board = boardDao.selectByBno(bno);
		return board;
	}
	
	@Override
	public Board getBoardOnlyAttachData(int bno) {
		Board board = boardDao.selectBattachDataByBno(bno);
		return board;
	}
	
	@Override
	public void addHitCount(int bno) {
		Board dbBoard = boardDao.selectByBno(bno);
		dbBoard.setBhitcount(dbBoard.getBhitcount()+1);
		
		boardDao.updateByBno(dbBoard);
	}
	
	@Override
	public int getTotalBoardNum() {
		int count = boardDao.count();	
		return count;
	}
}
