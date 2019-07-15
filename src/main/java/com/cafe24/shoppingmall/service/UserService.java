package com.cafe24.shoppingmall.service;

import org.springframework.stereotype.Service;

import com.cafe24.shoppingmall.vo.UserVo;

@Service
public class UserService {

	public boolean checkId(String id) {
		if("test".equals(id)){
			return true;
		}
			return false;
	}

	public void join(UserVo userVo) {
		// join 
	}
 

	public UserVo login(UserVo userVo) {
		userVo=new UserVo();
		userVo.setId("user2");
		userVo.setPassword("1234");
		userVo.setName("김가나");
		userVo.setPhone("010-9999-4444");
		userVo.setEmail("asd@naver.com");
		userVo.setBirth("920101");
		return userVo;
	}
	

}
