package com.mycompany.yogitour.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.mycompany.yogitour.dto.Product;
import com.mycompany.yogitour.dto.Pager;

@Mapper
public interface ProductDao {
	
	public int insertProduct(Product product);
	public int insertMedia(Product product);
	public List<Product> selectAll();
	public Product selectByProductNo(int ProductNo);
	public Product selectBattachDataByProductNo(int productNo);
	public int deleteByProductNo(int bno);
	public List<Product> selectProductListByCategory(String category);
}
