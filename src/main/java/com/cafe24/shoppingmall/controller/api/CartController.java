package com.cafe24.shoppingmall.controller.api;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.vo.ProductVo;
import com.cafe24.shoppingmall.vo.UserVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController("cartAPIController")
@RequestMapping("/api/cart")
public class CartController {
	
	@ApiOperation(value="장바구니 담기")
	@RequestMapping(value="/addCart/{no}",method=RequestMethod.GET)
	public JSONResult addCart(@PathVariable(value="no") int no) {
		return JSONResult.success(no);
	}
	
	@ApiOperation(value="장바구니 보기")
	@RequestMapping(value="/showCart",method=RequestMethod.GET)
	public JSONResult showCart() {
		ArrayList<ProductVo> list= new ArrayList<ProductVo>();
		return JSONResult.success(list);
	}
	 
	
	
	
		
	
	
	
}
