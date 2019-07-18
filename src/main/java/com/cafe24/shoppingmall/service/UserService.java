package com.cafe24.shoppingmall.service;

import com.cafe24.shoppingmall.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.shoppingmall.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	/***
	 * 	id 중복 체크. 중복이라면 true/ 중복이 아니라면 false 반환
	 * */
	public boolean checkId(String id) {
		return userDao.checkById(id);
	}

	/**
	 *  회원가입 성공시 true/ 실패시 false 반환
	 * */
	public boolean join(UserVo userVo) {
		return userDao.insert(userVo);
	}

	/***
	 *  login 정보가 있으면 userVo 반환
	 *  없으면 null 반환
	 */
	public UserVo login(UserVo userVo) {
		return userDao.login(userVo);
	}
	

}
