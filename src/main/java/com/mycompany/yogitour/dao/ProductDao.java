package com.mycompany.yogitour.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.mycompany.yogitour.dto.Product;
import com.mycompany.yogitour.dto.ImageQuery;
import com.mycompany.yogitour.dto.Media;

@Mapper
public interface ProductDao {
	
	public int insertProduct(Product product);
	public int insertMedia(Media media);
	public List<Product> selectAll();
	public List<Product> selectRandomTen();
	public List<Product> selectBySearchKeyword(String searchKeyword);
	public Product selectByProductNo(int ProductNo);
	public Media selectBattachData(ImageQuery imageQuery);
	public int deleteByProductNo(int bno);
	public List<Product> selectProductListByCategory(String category);
}
