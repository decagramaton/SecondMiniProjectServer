package com.mycompany.yogitour.service;

import java.util.List;

import com.mycompany.yogitour.dto.Product;
import com.mycompany.yogitour.dto.Wish;
import com.mycompany.yogitour.dto.Board;
import com.mycompany.yogitour.dto.Media;
import com.mycompany.yogitour.dto.Pager;

public interface WishService {
	public int checkWish(int productNo, int userNo);
	public void clickWishBtn(int productNo, int userNo);
	public List<Product> getWish(int userNo);
}
