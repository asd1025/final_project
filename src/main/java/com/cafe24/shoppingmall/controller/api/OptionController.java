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
			@ApiImplicitParam(name="optionVo",value="optionVo",required = true, dataType = "optionVo", paramType = "query", defaultValue = "")
	})
	public ResponseEntity<JSONResult> regCategory(@RequestBody OptionVo optionVo) {
		boolean irRegOption = optionService.regOption(optionVo);
		if(!irRegOption){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("카테고리 등록 실패"));
		}
		else return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(optionVo));
	}

//	/**
//	 * 카테고리들을 다 보여준다.
//	 */
//	@ApiOperation(value="카테고리 전체 보기")
//	@GetMapping(value="")
//	public ResponseEntity<JSONResult> getAllCategory() {
//		ArrayList<CategoryVo> list= (ArrayList<CategoryVo>) categoryService.getList();
//		if(list.size()!=0) return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
//		else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("fail"));
//	}
//	/**
//	 * 해당 카테고리를 보여준다
//	 */
//	@ApiOperation(value="카테고리  보기")
//	@ApiImplicitParam(name="no",value="카테고리 번호",required = true, dataType = "int", paramType = "path", defaultValue = "")
//	@GetMapping(value="/{no}")
//	public ResponseEntity<JSONResult> getCategoryByNo(@PathVariable int no) {
//		CategoryVo categoryVo= categoryService.getCategoryByNo(no);
//		if(categoryVo!=null) return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(categoryVo));
//		else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("fail"));
//	}
//
//
//	/***
//	 *
//	 *  카테고리를 삭제한다
//	 *  상위 카테고리를 삭제하면, 그 번호를 parent로 가지고 있는 카테고리들(하위카테고리)들도 삭제된다.
//	 *  다만, 관련된 물품들은 default 분류인 미분류로 들어가게 된다.
//	 *
//	 */
//	@ApiOperation(value="카테고리 삭제")
//	@ApiImplicitParams({
//			@ApiImplicitParam(name="no",value="카테고리 번호",required = true, dataType = "int", paramType = "path", defaultValue = "")
//	})
//	@DeleteMapping(value="/{no}")
//	public ResponseEntity<JSONResult> deleteCartBynNo(@PathVariable int no) {
//		if(categoryService.deleteCategoryByNo(no)) return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success("success"));
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("fail"));
//	}
//	/***
//	 * 카테고리 내용을 수정한다.
//	 */
//	@ApiOperation(value="카테고리 수정")
//	@ApiImplicitParam(name="categoryVo",value="categoryVo",required = true, dataType = "categoryVo", paramType = "query", defaultValue = "")
//	@PutMapping(value="")
//	public ResponseEntity<JSONResult> updateCart(@RequestBody CategoryVo categoryVo) {
//		if(categoryService.updateCategory(categoryVo)) return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success("success"));
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("fail"));
//	}

	
	
	
}
