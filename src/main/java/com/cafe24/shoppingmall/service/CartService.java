package com.cafe24.shoppingmall.service;

import java.util.ArrayList;

import com.cafe24.shoppingmall.vo.CartVo;
import org.springframework.stereotype.Service;


@Service
public class CartService {

	/***
	 *  회원의 아이디와 상품재고번호를 받아 Cart를 생성한다.
	 */
	public boolean addCart(CartVo cartVo) {
		if(cartVo!=null)
		return true;
		else return false;
	}

	/**
	 *  회원 ID를 받아, 그 회원의 Cart에 담긴 상품들을 다 보여준다.
	 * */
	public ArrayList<CartVo> getList(String id) {
		ArrayList<CartVo> list=new ArrayList<CartVo>();
		CartVo vo1=new CartVo();
		vo1.setNo(1);
		CartVo vo2=new CartVo();
		vo2.setNo(10);
		list.add(vo1);
		list.add(vo2);
		return list;
	}

	/**
	 *  삭제 처리가 들어온 상품을 카트에서 삭제해준다.
	 * **/
	public void deleteCart(int no) {
		// TODO Auto-generated method stub
		
	}
	
	

}
