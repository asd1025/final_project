package com.cafe24.shoppingmall.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.service.UserService;
import com.cafe24.shoppingmall.vo.UserVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController("userAPIController")
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@ApiOperation(value="아이디 중복 조회")
	@RequestMapping(value="/checkid/{id}",method=RequestMethod.GET)
	public JSONResult checkId(@PathVariable(value="id") String id) {
		System.out.println(id);
		
		return JSONResult.success(id);
	}
	
	@ApiOperation(value="회원 가입")
	@RequestMapping(value="/join",method=RequestMethod.POST)
	public JSONResult join(@RequestBody UserVo userVo) {
		userService.join(userVo);
		return JSONResult.success(userVo);
	}
	
	@ApiOperation(value="로그인")
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public JSONResult login(@RequestBody UserVo userVo) {
		boolean isCheckedLogin = userService.loginCheck(userVo);
		return JSONResult.success(userVo);
	}
	
	
	
	
		
	
	
	
}
