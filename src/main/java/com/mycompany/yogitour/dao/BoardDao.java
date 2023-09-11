package com.mycompany.yogitour.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.mycompany.yogitour.dto.Board;
import com.mycompany.yogitour.dto.Pager;

@Mapper
public interface BoardDao {
	
	public int insert(Board board);
	public List<Board> selectByPage(Pager pager);
	public List<Board> selectAll();
	public Board selectByBno(int bno);
	public Board selectBattachDataByBno(int bno);
	public int updateByBno(Board board);
	public int deleteByBno(int bno);
	public int count();
}
