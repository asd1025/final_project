package com.cafe24.shoppingmall.controller;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.service.OptionDetailService;
import com.cafe24.shoppingmall.service.PhotoService;
import com.cafe24.shoppingmall.vo.OptionDetailVo;
import com.cafe24.shoppingmall.vo.PhotoVo;
import com.cafe24.shoppingmall.vo.ProductVo;
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
	 *  리스트로 등록
	 * */

	@ApiOperation(value="사진 등록")
	@PostMapping(value="")
	@ApiImplicitParams({
			@ApiImplicitParam(name="photoList",value="list",required = true, dataType = "list", paramType = "query", defaultValue = "")
	})
	public ResponseEntity<JSONResult> regPhotos(@RequestBody List<PhotoVo> photoList) {
		if(photoList.size()!=0){
			boolean isAble = photoService.regPhotos(photoList);
			if(!isAble){
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("사진 등록 실패"));
			}
		}else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("등록하는 사진이 없음"));
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(photoList));
	}


	/**
	 * 상품 사진들을 불러온다
	 */
	@ApiOperation(value="상품 사진 전체 보기")
	@ApiImplicitParam(name="productNo",value="상품 번호",required = true, dataType = "int", paramType = "path", defaultValue = "")
	@GetMapping(value="/{productNo}")
	public ResponseEntity<JSONResult> getAllPhotosByProductNo(@PathVariable int productNo) {
		ArrayList<PhotoVo> list= (ArrayList<PhotoVo>) photoService.getListByProductNo(productNo);
		if(list.size()!=0) return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
		else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("fail"));
	}

	/***
	 * 사진 수정
	 * 수정은 기존 사진을 다 삭제하고, 다시 insert
	 */
	@ApiOperation(value="상품 사진 수정")
	@ApiImplicitParams({
			@ApiImplicitParam(name="productNo",value="상품 번호",required = true, dataType = "int", paramType = "path", defaultValue = ""),
			@ApiImplicitParam(name="photoList",value="list",required = true, dataType = "list", paramType = "query", defaultValue = "")
	})
	@PutMapping(value="/{productNo}")
	public ResponseEntity<JSONResult> updateOptionDetail(@PathVariable int productNo,@RequestBody List<PhotoVo> photoList) {
		if(photoService.update(productNo,photoList)) return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success("success"));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("fail"));
	}


	/**
	/***
	 * 상품 사진 삭제
	 */
	@ApiOperation(value="상품 사진 삭제")
	@ApiImplicitParams({
			@ApiImplicitParam(name="productNo",value="상품 번호",required = true, dataType = "int", paramType = "path", defaultValue = ""),
	})
	@DeleteMapping(value="/{productNo}")
	public ResponseEntity<JSONResult> deletePhotos(@PathVariable int productNo) {
		if(photoService.deletePhotoByProductNo(productNo)) return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success("success"));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("fail"));
	}

	
}
