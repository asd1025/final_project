package com.cafe24.shoppingmall.controller.api;

import java.util.ArrayList;

import com.cafe24.shoppingmall.vo.CartVo;
import com.cafe24.shoppingmall.vo.UserVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.service.CartService;

import io.swagger.annotations.ApiOperation;


@RestController("cartAPIController")
@RequestMapping("/api")
public class CartController {
	
	@Autowired
	CartService cartService;
	

	/**
	 *  장바구니 담기
	 *  cartVo의 정보를 카트에 담는다.
	 * */
	@ApiOperation(value="장바구니 담기")
	@RequestMapping(value="/cart",method=RequestMethod.POST)
	@ApiImplicitParams({
			@ApiImplicitParam(name="cartVo",value="cartVo",required = true, dataType = "cartVo", paramType = "query", defaultValue = "")
	})
	public ResponseEntity<JSONResult> addCart(@RequestBody CartVo cartVo) {
		boolean isAddCart = cartService.addCart(cartVo);
		if(!isAddCart){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("카트 담기 실패"));
		}
		else return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(cartVo));
	}

	/**
	 * 회원 아이디의 장바구니 상품들을 다 보여준다.
	 */
	@ApiOperation(value="장바구니 보기")
	@ApiImplicitParam(name="id",value="회원id",required = true, dataType = "String", paramType = "path", defaultValue = "")
	@RequestMapping(value="/cart/{id}",method=RequestMethod.GET)
	public JSONResult showCart(@RequestBody String id) {
		ArrayList<CartVo> list=cartService.getList(id);
		return JSONResult.success(list);
	}

	@ApiOperation(value="장바구니 삭제")
	@RequestMapping(value="/cart/{id}/{no}",method=RequestMethod.DELETE)
	public JSONResult deleteCart(@RequestBody int no,String id) {
		cartService.deleteCart(no);
		return JSONResult.success(true);
	}
	 
	
	
	
		
	
	
	
}
