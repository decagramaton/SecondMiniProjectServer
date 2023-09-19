package com.mycompany.yogitour.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.yogitour.dto.Board;
import com.mycompany.yogitour.dto.Media;
import com.mycompany.yogitour.dto.Product;
import com.mycompany.yogitour.interceptor.Login;
import com.mycompany.yogitour.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;	
	
	/**
	 * 전체 상품 목록을 조회하는 메소드
	 * @author 고재승, 박재홍
	 * @return 상품 목록
	 */
	@GetMapping(value="/getProductList", produces="application/json; charset=UTF-8")
	public List<Board> getProductList(){
		log.info("실행");
		List<Board> boardList = productService.getList();
		return boardList;
	}
	
	@GetMapping(value="/getProductByProductNo", produces="application/json; charset=UTF-8")
	public Board getProductByProductNo(int productNo) {
		return productService.getProduct(productNo);
	}
	
	
	/**
	 * 카테고리 조건으로 전체 상품을 조회하는 메소드
	 * @author 고재승
	 * @return 상품 목록
	 */
	@GetMapping(value="getProductListByCategory", produces="application/json; charset=UTF-8")
	public List<Board> getProductListByCategory(String category) {
		return productService.getListByCategory(category);
	}
	
	/**
	 * 검색 키워드 조건으로 상품 목록을 조회하는 메소드
	 * @author 고재승
	 * @return 게시글 목록
	 */
	@GetMapping(value="getProductListBySearchKeyword", produces="application/json; charset=UTF-8")
	public List<Board> getProductListBySearchKeyword(String searchKeyword) {
		return productService.getProductListBySearchKeyword(searchKeyword);
	}
	
	
	/**
	 * 단일 상품의 모든 정보를 조회하는 메소드
	 * @author 고재승
	 * @param bno
	 * @return
	 */
	/*@GetMapping(value="/getProduct", produces="application/json; charset=UTF-8")
	public Product getBoard(int productNo){
		return productService.getProduct(productNo);
	}*/
	
	/**
	 * 게시글의 초기 정보를 조회하는 메소드
	 * 
	 * 
	 */
	@GetMapping(value="/getProductDetail", produces="application/json; charset=UTF-8")
	public Product getProductDetail(int productNo) {
		return productService.getProductDetail(productNo);
	}
	
	
	/**
	 * 이미지 파일 다운로드 메소드
	 * @author 교수님
	 * @param productNo
	 * @return Image Byte[]
	 */
	@GetMapping(value="/fileDownload", produces="image/jpeg")
	public byte[] fileDownload(int productNo, String mediaName){
		Media media = productService.getProductOnlyAttachData(productNo, mediaName);
		return media.getMediaData();
	}
	
	
	
	/**
	 * 상품 게시글 작성 메소드
	 * @param board
	 * @return
	 */
	@Login
	@PostMapping(value="/writeProduct", produces="application/json; charset=UTF-8")
	public String writeProduct(Product product) {
			
		JSONObject jsonObject = new JSONObject();
		
		try {
			/*//MultipartFile 여부 확인
			MultipartFile mf = product.getBattach();
			
			// MultipartFile 없으면 File의 데이터 타입과, Byte를 DTO에 추가
			if(!mf.isEmpty()) {
				product.setProductMediaType(mf.getContentType());
				product.setProductMediaData(mf.getBytes());
			}*/
			
			// DB에 작성글 추가 요청
			productService.write(product);
			
			// 추가 성공 시, 요청 결과와 요청한 작성글 번호 반환
			jsonObject.put("result", "success");
			jsonObject.put("productNo", product.getProductNo());
			
		} catch (Exception e) {
			// 추가 실패 시, 요청 결과와 실패 사유 반환
			jsonObject.put("result", "fail");
			jsonObject.put("message", e.getMessage());
		}
		
		return jsonObject.toString();

	}
	
}
