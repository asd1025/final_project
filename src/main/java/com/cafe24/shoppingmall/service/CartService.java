package com.cafe24.shoppingmall.service;

import java.util.List;

import com.cafe24.shoppingmall.repository.CartDao;
import com.cafe24.shoppingmall.vo.CartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CartService {

	@Autowired
 	private CartDao cartDao;

	/***
	 *  회원의 아이디와 상품재고번호를 받아 Cart를 생성한다.
	 */
	public boolean addCart(CartVo cartVo) {
		return cartDao.insert(cartVo);
	}

	/**
	 *  회원 ID를 받아, 그 회원의 Cart에 담긴 상품들을 다 보여준다.
	 * */
	public List<CartVo> getList(String id) {
		return  cartDao.getList(id);
 	}

	/**
	 *  삭제 처리가 들어온 상품을 카트에서 삭제해준다.
	 * **/
    public boolean deleteCartBynNo(int stockNo,String id) {
		return 0!=cartDao.deleteCartByNo(stockNo,id);
	}

	/**
	 *  해당 ID의 장바구니들을 모두 삭제한다.
	 * **/
	public boolean deleteAllCartById(String id) {
		return 0!=cartDao.deleteAllCartById(id);
	}

}
