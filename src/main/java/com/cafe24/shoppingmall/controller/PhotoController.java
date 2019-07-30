package com.cafe24.shoppingmall.controller;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.service.OptionDetailService;
import com.cafe24.shoppingmall.service.PhotoService;
import com.cafe24.shoppingmall.vo.OptionDetailVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController("photoAPIController")
@RequestMapping("/api/photo")
public class PhotoController {
	
	@Autowired
	PhotoService photoService;
	

	/**
	 *  사진 등록하기
	 * */

	@ApiOperation(value="사진 등록")
	@PostMapping(value="")
	@ApiImplicitParams({
			@ApiImplicitParam(name="optionDetailVoList",value="list",required = true, dataType = "list", paramType = "query", defaultValue = "")
	})
	public ResponseEntity<JSONResult> regOptionDetail(@RequestBody List<OptionDetailVo> optionDetailVo) {
		if(optionDetailVo.size()!=0){
			boolean irRegOption = optionDetailService.regOptionDetail(optionDetailVo);
			if(!irRegOption){
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("옵션 디테일 등록 실패"));
			}
		}else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("옵션 디테일 정보 없음"));
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(optionDetailVo));
	}


	/**
	 * 옵션 디테일들을 다 보여준다.
	 */
	@ApiOperation(value="옵션 디테일 전체 보기")
	@GetMapping(value="")
	public ResponseEntity<JSONResult> getAllOptionDetail() {
		ArrayList<OptionDetailVo> list= (ArrayList<OptionDetailVo>) optionDetailService.getList();
		if(list.size()!=0) return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
		else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("fail"));
	}

	/**
	 * 해당 옵션번호의 옵션 디테일들을 보여준다.
	 */
	@ApiOperation(value="해당 옵션의 옵션디테일 보기")
	@ApiImplicitParam(name="no",value="옵션 번호",required = true, dataType = "int", paramType = "path", defaultValue = "")
	@GetMapping(value="/option/{no}")
	public ResponseEntity<JSONResult> getOptionDetailByOptionNo(@PathVariable int no) {
		ArrayList<OptionDetailVo> list= (ArrayList<OptionDetailVo>) optionDetailService.getOptionDetailByOptionNo(no);
		if(list.size()!=0)  return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
		else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("fail"));
	}

	/**
	 * 해당 옵션 디테일을 보여준다.
	 */
	@ApiOperation(value="옵션 디테일 보기")
	@ApiImplicitParam(name="no",value="옵션 디테일 번호",required = true, dataType = "int", paramType = "path", defaultValue = "")
	@GetMapping(value="/{no}")
	public ResponseEntity<JSONResult> getOptionDetailByNo(@PathVariable int no) {
		OptionDetailVo vo=   optionDetailService.getOptionDetailByNo(no);
		if(vo!=null) return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(vo));
		else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("fail"));
	}

	/***
	 * 디테일 옵션 번호를 통해
	 *  디테일 옵션을 삭제한다
	 */
	@ApiOperation(value="디테일 옵션 삭제")
	@ApiImplicitParams({
			@ApiImplicitParam(name="no",value="디테일 옵션 번호",required = true, dataType = "int", paramType = "path", defaultValue = "")
	})
	@DeleteMapping(value="/{no}")
	public ResponseEntity<JSONResult> deleteOptionDetailBynNo(@PathVariable int no) {
		if(optionDetailService.deleteOptionDetailBynNo(no)) return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success("success"));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("fail"));
	}

	/***
	 * 옵션 번호를 통해
	 *  디테일 옵션들을 삭제한다
	 */
	@ApiOperation(value="옵션번호로 디테일 옵션 삭제")
	@ApiImplicitParams({
			@ApiImplicitParam(name="no",value="옵션 번호",required = true, dataType = "int", paramType = "path", defaultValue = "")
	})
	@DeleteMapping(value="/option/{no}")
	public ResponseEntity<JSONResult> deleteOptionDetailByOptionNo(@PathVariable int no) {
		if(optionDetailService.deleteOptionDetailByOptionNo(no)) return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success("success"));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("fail"));
	}

	/***
	 * 옵션 디테일을 수정한다.
	 */
	@ApiOperation(value="옵션 디테일 수정")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "optionDetailVo", value = "optionDetailVo", required = true, dataType = "optionDetailVo", paramType = "query", defaultValue = "")
	})
	@PutMapping(value="")
	public ResponseEntity<JSONResult> updateOptionDetail(@RequestBody OptionDetailVo optionDetailVo) {
		if(optionDetailService.updateOptionDetail(optionDetailVo)) return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success("success"));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("fail"));
	}

	
	
	
}
