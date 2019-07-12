package com.cafe24.shoppingmall.service;

import org.springframework.stereotype.Service;

import com.cafe24.shoppingmall.vo.UserVo;

@Service
public class UserService {

	public boolean checkId(String id) {
		System.out.println("haha");
		return true;
	}

	public void join(UserVo userVo) {
		// join 
	}

	public boolean loginCheck(UserVo userVo) {
		return true;
	}
	

}
