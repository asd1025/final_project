package com.cafe24.shoppingmall.controller.api;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.service.UserService;
import com.cafe24.shoppingmall.vo.UserVo;

import io.swagger.annotations.ApiOperation;

import java.util.List;
import java.util.Set;

@RestController("userAPIController")
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@Autowired
	private MessageSource messageSource;
	
	/**
	 *  아이디 중복 체크
	 *  Get으로 받은 id의 중복체크
	 *  true : id 사용불가 (중복) / false : id 사용 가능
	 * **/

	@ApiOperation(value="아이디 중복 조회")
	@ApiImplicitParam(name="id",value="회원ID",required = true, dataType = "string", paramType = "path", defaultValue = "")
	@RequestMapping(value="/checkId/{id}",method=RequestMethod.GET)
	public ResponseEntity<JSONResult> checkId(@PathVariable(value="id") String id) {
		Validator validator= Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<UserVo>> validatorResults = validator.validateProperty(new UserVo(id),"id");
		if(!validatorResults.isEmpty()){
			for(ConstraintViolation<UserVo> validatorResult:validatorResults){
				String message=messageSource.getMessage("Id.userVo.id",null, LocaleContextHolder.getLocale());
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail(message));
			}
		}
		boolean isExistedId = userService.checkId(id);
		if(isExistedId){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("ID 중복"));
		}
		else return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success("success"));
	}
	
	/**
	 * 회원 가입 
	 * POST 방식으로 회원 기본 정보를 받는다.
	 * Gender는 기본:MALE
	 * MembershipStatus는 기본:MEMBER
	 * 
	 * */
	@ApiOperation(value="회원 가입")
	@PostMapping(value="/join")
	@ApiImplicitParams({
	@ApiImplicitParam(name="userVo",value="회원",required = true, dataType = "userVo", paramType = "query", defaultValue = "")
	})
	public ResponseEntity<JSONResult> join(@RequestBody @Valid UserVo userVo, BindingResult result) {
	    if(result.hasErrors()){
	        List<ObjectError> list = result.getAllErrors();
	        for(ObjectError error:list){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail(error.getDefaultMessage()));
            }
        }

		boolean joinReuslt=userService.join(userVo);
	    if(joinReuslt)  return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(userVo));
	    else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("회원 가입을 실패했습니다."));
	}
	
	/**
	 * 로그인 check
	 * POST로 받은 ID, PASSWORD로 로그인 체크를 하여,
	 * 존재한다면 해당 UserVo 객체를, 없다면 null 을 반환한다
	 **/
	@ApiOperation(value="로그인")
	@PostMapping(value="/login")
	@ApiImplicitParams({
			@ApiImplicitParam(name="userVo",value="회원",required = true, dataType = "userVo", paramType = "query", defaultValue = "")
	})
	public ResponseEntity<JSONResult> login(@RequestBody UserVo userVo) {
		UserVo authUser = userService.login(userVo);
		if(authUser!=null) {
		 return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(authUser));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("fail"));

	}
	
	
	
	
		
	
	
	
}
