package com.mycompany.yogitour.service;

import java.util.List;

import com.mycompany.yogitour.dto.Product;
import com.mycompany.yogitour.dto.Board;
import com.mycompany.yogitour.dto.Media;
import com.mycompany.yogitour.dto.Pager;

public interface ProductService {
	public void write(Product product);
	public void remove(int bno);
	public List<Board> getList();
	public List<Board> getProductListBySearchKeyword(String searchKeyword);
	public Board getProduct(int productNo);
	public Media getProductOnlyAttachData(int productNo, String mediaName);	
	public List<Board> getListByCategory(String category);
	public Product getProductDetail(int productNo);
}
