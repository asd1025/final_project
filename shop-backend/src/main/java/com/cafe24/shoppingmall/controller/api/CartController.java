package com.cafe24.shoppingmall.controller.api;

import java.util.ArrayList;

import com.cafe24.shoppingmall.vo.CartVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.service.CartService;

import io.swagger.annotations.ApiOperation;


@RestController("cartAPIController")
@RequestMapping("/api/cart")
public class CartController {
	
	@Autowired
	CartService cartService;
	

	/**
	 *  장바구니 담기
	 *  cartVo의 정보를 카트에 담는다.
	 * */

	@ApiOperation(value="장바구니 담기")
	@PostMapping(value="")
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
	@ApiImplicitParam(name="id",value="회원 아이디",required = true, dataType = "string", paramType = "path", defaultValue = "")
	@GetMapping(value="/{id}")
	public ResponseEntity<JSONResult> showCart(@PathVariable(value="id") String id) {
		ArrayList<CartVo> list= (ArrayList<CartVo>) cartService.getList(id);
		if(list.size()!=0) return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
		else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("fail"));
	}


	/***
	 *
	 *  해당 상품을 삭제한다
	 */
	@ApiOperation(value="카트 상품 삭제")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "회원 아이디", required = true, dataType = "string", paramType = "path", defaultValue = ""),
			@ApiImplicitParam(name = "stock_no", value = "상품번호", required = true, dataType = "int", paramType = "path", defaultValue = "")

	})
	@DeleteMapping(value="/{id}/{stock_no}")
	public ResponseEntity<JSONResult> deleteCartBynNo(@PathVariable int stock_no,@PathVariable String id) {
		if(cartService.deleteCartByNo(stock_no,id)) return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success("success"));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("fail"));
	}

	/***
	 *
	 *  해당 ID의 장바구니를 모두 삭제한다
	 */
	@ApiOperation(value="장바구니 전체 삭제")
	@ApiImplicitParam(name = "id", value = "회원 아이디", required = true, dataType = "string", paramType = "path", defaultValue = "")
	@DeleteMapping(value="/{id}")
	public ResponseEntity<JSONResult> deleteAllCartById(@PathVariable String id) {
		if(cartService.deleteAllCartById(id)) return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success("success"));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("fail"));
	}

	/***
	 * 카트 안의 물품 수량을 수정한다.
	 */
	@ApiOperation(value="장바구니 수정")
	@ApiImplicitParam(name="cartVo",value="cartVo",required = true, dataType = "cartVo", paramType = "query", defaultValue = "")
	@PutMapping(value="")
	public ResponseEntity<JSONResult> updateCart(@RequestBody CartVo cartVo) {
		if(cartService.updateCart(cartVo)) return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success("success"));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("fail"));
	}

	
	
	
}
