package com.cafe24.shoppingmall.controller.api;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.service.ProductService;
import com.cafe24.shoppingmall.vo.ProductVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController("productAPIController")
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    /**
     *  상품을 등록한다
     * */

    @ApiOperation(value="상품 등록하기")
    @PostMapping(value="")
    @ApiImplicitParams({
            @ApiImplicitParam(name="productVo",value="productVo",required = true, dataType = "productVo", paramType = "query", defaultValue = "")
    })
    public ResponseEntity<JSONResult> regProduct(@RequestBody ProductVo productVo) {


        boolean isRegProduct = productService.regProduct(productVo);
        if(!isRegProduct){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("상품 등록 실패"));
        }
        else return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(productVo));
    }

    /**
     * 등록된 상품들을 모두 보여준다.
     */
    @ApiOperation(value="등록된 상품 모두 보기")
    @GetMapping(value="")
    public ResponseEntity<JSONResult> getList() {
        ArrayList<ProductVo> list= (ArrayList<ProductVo>) productService.getList();
        if(list.size()!=0) return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("fail"));
    }

    /**
     * 해당 번호의 상품을 보여준다.
     */
    @ApiOperation(value="해당 번호의 상품 보기")
    @ApiImplicitParam(name="no",value="no",required = true, dataType = "int", paramType = "path", defaultValue = "")
    @GetMapping(value="/{no}")
    public ResponseEntity<JSONResult> getProductByNo(@PathVariable int no) {
        ProductVo productVo= productService.getProductByNo(no);
        if(productVo!=null) return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(productVo));
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("fail"));
    }

    /**
     * 해당 번호의 상품을 삭제한다
     */
    @ApiOperation(value="해당 번호의 상품 삭제")
    @ApiImplicitParam(name="no",value="no",required = true, dataType = "int", paramType = "path", defaultValue = "")
    @DeleteMapping(value="/{no}")
    public ResponseEntity<JSONResult> deleteProduct(@PathVariable int no) {
        if(productService.deleteProduct(no)) return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success("success"));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("fail"));
    }

    /**
     * 해당 번호의 상품을 수정한다
     */
    @ApiOperation(value="해당 번호의 상품 수정")
    @ApiImplicitParam(name="productVo",value="productVo",required = true, dataType = "productVo", paramType = "query", defaultValue = "")
    @PutMapping(value="")
    public ResponseEntity<JSONResult> updateProduct(@RequestBody ProductVo productVo) {
            if(productService.updateProduct(productVo)) return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success("success"));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("fail"));
        }
    }


