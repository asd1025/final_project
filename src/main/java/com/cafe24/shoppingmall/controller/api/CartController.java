package com.cafe24.shoppingmall.controller.api;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.service.CartService;
import com.cafe24.shoppingmall.util.CookieIdMaker;
import com.cafe24.shoppingmall.vo.CartVo;
import com.cafe24.shoppingmall.vo.ProductVo;
import com.cafe24.shoppingmall.vo.UserVo;

import io.swagger.annotations.ApiOperation;

@RestController("cartAPIController")
@RequestMapping("/api/cart")
public class CartController {
	
	@Autowired
	CartService cartService;
	
	
	// post 방식으로 다시 고치기 수량이랑 세션에있는 아이디 같이 넘겨줘야함 
	
	/**
	 *  장바구니 담기
	 *  SESSION 값 authUser의 유무를 확인하여 회원을 체크한다.
	 *  비회원일시, 쿠키 아이디 랜덤값을 생성하여 DB에 저장한다.
	 *  쿠키 아이디가 없다면 보여주지 않는다 ( 이때, DB에는 저장되어 있는 상태다)
	 *  쿠키의 보관은 1주
	 * */
	@ApiOperation(value="장바구니 담기")
	@RequestMapping(value="/addCart/{no}",method=RequestMethod.GET)
	public JSONResult addCart(@PathVariable(value="no") int no,HttpSession session,@CookieValue(value="cookiId") String cookieId,
			HttpServletResponse response) {
		UserVo vo=(UserVo) session.getAttribute("authUser");
		// 회원일떄 
		if(vo!=null) {
			cartService.addCart(no);
		}else {// 비회원일떄  
			if(cookieId==null) {
				Cookie cartCookie=new Cookie("cart",CookieIdMaker.generateRandomCookieId());
				cartCookie.setMaxAge(60*60*24*7); 
				response.addCookie(cartCookie);
			} 
			cartService.addCart(no);
		}
		return JSONResult.success(no);
	}
	
	@ApiOperation(value="장바구니 보기")
	@RequestMapping(value="/showCart",method=RequestMethod.POST)
	public JSONResult showCart(@RequestBody int no) {
		ArrayList<ProductVo> list=cartService.getList(no);
		return JSONResult.success(list);
	}
	
	@ApiOperation(value="장바구니 삭제")
	@RequestMapping(value="/showCart",method=RequestMethod.DELETE)
	public JSONResult deleteCart(@RequestBody int no) {
		cartService.deleteCart(no);
		return JSONResult.success(true);
	}
	 
	
	
	
		
	
	
	
}
