package com.cafe24.shoppingmall.controller.api;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.service.CartService;
import com.cafe24.shoppingmall.service.OrdersService;
import com.cafe24.shoppingmall.vo.CartVo;
import com.cafe24.shoppingmall.vo.OrdersVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RestController("ordersAPIController")
@RequestMapping("/api/orders")
public class OrdersController {
	
	@Autowired
	OrdersService ordersService;
	

	/**
	 *  상품을 주문한다
	 * */

	@ApiOperation(value="상품주문")
	@PostMapping(value="")
	@ApiImplicitParams({
			@ApiImplicitParam(name="ordersVo",value="ordersVo",required = true, dataType = "ordersVo", paramType = "query", defaultValue = "")
	})
	public ResponseEntity<JSONResult> addCart(@RequestBody @Valid OrdersVo ordersVo, BindingResult result) {
		if(result.hasErrors()){
			List<ObjectError> list = result.getAllErrors();
			for(ObjectError error:list){
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail(error.getDefaultMessage()));
			}
		}
		boolean isAble = ordersService.doOrder(ordersVo);
		if(!isAble){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("주문하기 실패"));
		}
		else return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(ordersVo));
	}

//
//	/**
//	 * 회원 아이디의 장바구니 상품들을 다 보여준다.
//	 */
//	@ApiOperation(value="장바구니 보기")
//	@ApiImplicitParam(name="id",value="회원 아이디",required = true, dataType = "string", paramType = "path", defaultValue = "")
//	@GetMapping(value="/{id}")
//	public ResponseEntity<JSONResult> showCart(@PathVariable(value="id") String id) {
//		ArrayList<CartVo> list= (ArrayList<CartVo>) cartService.getList(id);
//		if(list.size()!=0) return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
//		else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("fail"));
//	}
//
//
//	/***
//	 *
//	 *  해당 상품을 삭제한다
//	 */
//	@ApiOperation(value="카트 상품 삭제")
//	@ApiImplicitParams({
//			@ApiImplicitParam(name = "id", value = "회원 아이디", required = true, dataType = "string", paramType = "path", defaultValue = ""),
//			@ApiImplicitParam(name = "stock_no", value = "상품번호", required = true, dataType = "int", paramType = "path", defaultValue = "")
//
//	})
//	@DeleteMapping(value="/{id}/{stock_no}")
//	public ResponseEntity<JSONResult> deleteCartBynNo(@PathVariable int stock_no,@PathVariable String id) {
//		if(cartService.deleteCartByNo(stock_no,id)) return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success("success"));
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("fail"));
//	}
//
//	/***
//	 *
//	 *  해당 ID의 장바구니를 모두 삭제한다
//	 */
//	@ApiOperation(value="장바구니 전체 삭제")
//	@ApiImplicitParam(name = "id", value = "회원 아이디", required = true, dataType = "string", paramType = "path", defaultValue = "")
//	@DeleteMapping(value="/{id}")
//	public ResponseEntity<JSONResult> deleteAllCartById(@PathVariable String id) {
//		if(cartService.deleteAllCartById(id)) return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success("success"));
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("fail"));
//	}
//
//	/***
//	 * 카트 안의 물품 수량을 수정한다.
//	 */
//	@ApiOperation(value="장바구니 수정")
//	@ApiImplicitParam(name="cartVo",value="cartVo",required = true, dataType = "cartVo", paramType = "query", defaultValue = "")
//	@PutMapping(value="")
//	public ResponseEntity<JSONResult> updateCart(@RequestBody CartVo cartVo) {
//		if(cartService.updateCart(cartVo)) return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success("success"));
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("fail"));
//	}

	
	
	
}
