package com.cafe24.shoppingmall.service;

import org.springframework.stereotype.Service;

import com.cafe24.shoppingmall.vo.UserVo;

@Service
public class UserService {

	/***
	 * 	id 중복 체크. 중복이라면 true/ 중복이 아니라면 false
	 * */
	public boolean checkId(String id) {
		if("test".equals(id)){
			return true;
		}
			return false;
	}

	public boolean join(UserVo userVo) {
		// join
		return true;
	}
 

	public UserVo login(UserVo userVo) {
		UserVo user=new UserVo();
		user.setId("user2");
		user.setPassword("123456!a");
		user.setName("김가나");
		user.setPhone("010-9999-4444");
		user.setEmail("asd@naver.com");
		user.setBirth("920101");

		if((user.getId().equals(userVo.getId()))&&(user.getPassword().equals(userVo.getPassword())))
			return userVo;

		return null;
	}
	

}
