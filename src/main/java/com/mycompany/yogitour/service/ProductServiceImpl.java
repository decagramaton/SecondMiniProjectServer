package com.mycompany.yogitour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.yogitour.dao.ProductDao;
import com.mycompany.yogitour.dto.Product;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao productDao;
	
	@Override
	public void write(Product product) {
		productDao.insertProduct(product);
		productDao.insertMedia(product);
	}
	
	@Override
	public void remove(int bno) {
		productDao.deleteByProductNo(bno);
	}
		
	@Override
	public List<Product> getList() {
		List<Product> productList = productDao.selectAll();
		return productList;
	}
	
	@Override
	public Product getProduct(int productNo) {
		Product product = productDao.selectByProductNo(productNo);
		return product;
	}
	
	@Override
	public Product getBoardOnlyAttachData(int bno) {
		Product board = productDao.selectBattachDataByProductNo(bno);
		return board;
	}
	
	@Override
	public List<Product> getListByCategory(String category) {
		return productDao.selectProductListByCategory(category);
	}
}
