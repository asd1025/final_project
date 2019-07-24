package com.cafe24.shoppingmall.controller.api;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.service.CategoryService;
import com.cafe24.shoppingmall.service.OptionService;
import com.cafe24.shoppingmall.vo.CategoryVo;
import com.cafe24.shoppingmall.vo.OptionVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController("optionAPIController")
@RequestMapping("/api/option")
public class OptionController {
	
	@Autowired
	OptionService optionService;
	

	/**
	 *  옵션 등록하기
	 *  디테일 옵션과 함께 등록 한다.
	 * */

	@ApiOperation(value="옵션 등록")
	@PostMapping(value="")
	@ApiImplicitParams({
			@ApiImplicitParam(name="optionVoList",value="list",required = true, dataType = "list", paramType = "query", defaultValue = "")
	})
	public ResponseEntity<JSONResult> regOption(@RequestBody List<OptionVo> optionVo) {
		if(optionVo.size()!=0){
			boolean irRegOption = optionService.regOption(optionVo);
			if(!irRegOption){
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("옵션 등록 실패"));
			}
		}else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("옵션 정보 없음"));
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(optionVo));
	}


	/**
	 * 옵션들을 다 보여준다.
	 */
	@ApiOperation(value="옵션 전체 보기")
	@GetMapping(value="")
	public ResponseEntity<JSONResult> getAllOption() {
		ArrayList<OptionVo> list= (ArrayList<OptionVo>) optionService.getList();
		if(list.size()!=0) return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
		else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("fail"));
	}

	/**
	 * 해당 번호의 옵션을 보여준다.
	 */
	@ApiOperation(value="해당 옵션  보기")
	@ApiImplicitParam(name="no",value="옵션 번호",required = true, dataType = "int", paramType = "path", defaultValue = "")
	@GetMapping(value="/{no}")
	public ResponseEntity<JSONResult> getOptionByNo(@PathVariable int no) {
		 OptionVo  optionVo=   optionService.getOptionByNo(no);
		if(optionVo!=null) return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(optionVo));
		else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("fail"));
	}

	/**
	 * 해당 상품의 옵션들을 보여준다.
	 */
	@ApiOperation(value="해당 상품의 옵션들 보기")
	@ApiImplicitParam(name="no",value="상품 번호",required = true, dataType = "int", paramType = "path", defaultValue = "")
	@GetMapping(value="/product/{no}")
	public ResponseEntity<JSONResult> getOptionByProductNo(@PathVariable int no) {
		ArrayList<OptionVo> list= (ArrayList<OptionVo>)  optionService.getOptionByProductNo(no);
		if(list.size()!=0) return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
		else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("fail"));
	}

	/***
	 * 옵션 번호를 통해
	 *  옵션을 삭제한다
	 */
	@ApiOperation(value="옵션 삭제")
	@ApiImplicitParams({
			@ApiImplicitParam(name="no",value="옵션 번호",required = true, dataType = "int", paramType = "path", defaultValue = "")
	})
	@DeleteMapping(value="/{no}")
	public ResponseEntity<JSONResult> deleteOptionBynNo(@PathVariable int no) {
		if(optionService.deleteOptionBynNo(no)) return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success("success"));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("fail"));
	}

	/***
	 * 상품 번호를 통해
	 *  옵션을 삭제한다
	 */
	@ApiOperation(value="상품번호로 옵션 삭제")
	@ApiImplicitParams({
			@ApiImplicitParam(name="no",value="상품 번호",required = true, dataType = "int", paramType = "path", defaultValue = "")
	})
	@DeleteMapping(value="/product/{no}")
	public ResponseEntity<JSONResult> deleteOptionByProductNo(@PathVariable int no) {
		if(optionService.deleteOptionByProductNo(no)) return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success("success"));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("fail"));
	}

	/***
	 * 옵션을 수정한다.
	 */
	@ApiOperation(value="옵션 수정")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "optionVo", value = "optionVo", required = true, dataType = "optionVo", paramType = "query", defaultValue = "")
	})
	@PutMapping(value="")
	public ResponseEntity<JSONResult> updateOption(@RequestBody OptionVo optionVo) {
		if(optionService.updateOption(optionVo)) return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success("success"));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("fail"));
	}

	
	
	
}
