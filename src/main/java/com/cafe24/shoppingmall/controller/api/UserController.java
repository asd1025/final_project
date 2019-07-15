package com.cafe24.shoppingmall.controller.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.service.UserService;
import com.cafe24.shoppingmall.vo.UserVo;

import io.swagger.annotations.ApiOperation;

@RestController("userAPIController")
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 *  아이디 중복 체크
	 *  Get으로 받은 id의 중복체크
	 *  true : id 사용불가 (중복) / false : id 사용 가능
	 * **/
	@ApiOperation(value="아이디 중복 조회")
	@RequestMapping(value="/checkid/{id}",method=RequestMethod.GET)
	public JSONResult checkId(@PathVariable(value="id") String id) {

		boolean isExistedId = userService.checkId(id);
		if(isExistedId)
		return JSONResult.fail("ID Duplication");
		else return JSONResult.success(id);
	}
	
	/**
	 * 회원 가입 
	 * POST 방식으로 회원 기본 정보를 받는다.
	 * Gender는 기본:MALE
	 * MembershipStatus는 기본:MEMBER
	 * 
	 * */
	@ApiOperation(value="회원 가입")
	@RequestMapping(value="/join",method=RequestMethod.POST)
	public JSONResult join(@RequestBody UserVo userVo) {
		userService.join(userVo);
		return JSONResult.success(userVo);
	}
	
	/**
	 * 로그인 check
	 * POST로 받은 ID, PASSWORD로 로그인 체크를 하여,
	 * 존재한다면 해당 UserVo 객체를, 없다면 null 을 반환한다
	 **/
	@ApiOperation(value="로그인")
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public JSONResult login(@RequestBody UserVo userVo) {
		UserVo authUser = userService.login(userVo);
		if(authUser!=null) {
			return JSONResult.success(userVo);
		}
		return JSONResult.fail("login fail");

	}
	
	
	
	
		
	
	
	
}
