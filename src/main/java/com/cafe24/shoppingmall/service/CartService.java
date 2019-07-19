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
	 *  먼저 기존에 카트에 제품이 있는지 확인하고
	 *  있다면, 수량을 수정
	 *  없다면, 회원의 아이디와 상품재고번호를 받아 Cart를 생성한다.
	 *
	 */
	public boolean addCart(CartVo cartVo) {
		CartVo existCart=checkCartByIdAndStockNo(cartVo);
		if(existCart==null) return cartDao.insert(cartVo);
		else {
			existCart.setQuantity(cartVo.getQuantity()+existCart.getQuantity());
			return updateCart(existCart);
		}
	}

	/***
	 *  회원의 아이디와 상품재고번호를 통해 기존 Cart 유무를 확인한다.
	 */
	public CartVo checkCartByIdAndStockNo(CartVo cartVo) {
		return cartDao.getCartByIdAndStockNo(cartVo);
	}

	/**
	 *  cart 상품의 수량을 수정해준다.
	 * **/
	public boolean updateCartQuantity(CartVo cartVO, int quantity) {
		return 0!=cartDao.updateCartQuantity(cartVO,quantity);
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
    public boolean deleteCartByNo(int stockNo,String id) {
		return 0!=cartDao.deleteCartByNo(stockNo,id);
	}

	/**
	 *  해당 ID의 장바구니들을 모두 삭제한다.
	 * **/
	public boolean deleteAllCartById(String id) {
		return 0!=cartDao.deleteAllCartById(id);
	}

	/**
	 *  장바구니 update
	 * **/
	public boolean updateCart(CartVo cartVO) {
		return 0!=cartDao.update(cartVO);
	}


}
