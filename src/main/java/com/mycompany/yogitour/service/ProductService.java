package com.mycompany.yogitour.service;

import java.util.List;

import com.mycompany.yogitour.dto.Product;
import com.mycompany.yogitour.dto.Pager;

public interface ProductService {
	public void write(Product product);
	public void remove(int bno);
	public List<Product> getList();
	public Product getProduct(int productNo);
	public Product getBoardOnlyAttachData(int bno);	
	public List<Product> getListByCategory(String category);
}
