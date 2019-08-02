package com.cafe24.shoppingmall.controller.api;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.service.StockService;
import com.cafe24.shoppingmall.vo.StockVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController("stockAPIController")
@RequestMapping("/api/stock")
public class StockController {

    @Autowired
    private StockService stockService;
    /**
     *  재고(디테일상품) 을 등록한다
     * */

    @ApiOperation(value="상품재고 등록하기")
    @PostMapping(value="")
    @ApiImplicitParams({
            @ApiImplicitParam(name="stockList",value="list",required = true, dataType = "list", paramType = "query", defaultValue = "")
    })
    public ResponseEntity<JSONResult> regProduct(@RequestBody List<StockVo> stockList) {
        boolean isAble = stockService.regStock(stockList);
        if(!isAble){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("상품재고 등록 실패"));
        }
        else return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(stockList));
    }

    /**
     * 상품의 재고 상품(디테일 상품)들을 보여준다
     */
    @ApiOperation(value="상품번호의 재고상품 모두 보기")
    @ApiImplicitParam(name="productNo",value="상품번호",required = true, dataType = "int", paramType = "path", defaultValue = "")
    @GetMapping(value="/product/{productNo}")
    public ResponseEntity<JSONResult> getListByProductNo(@PathVariable int productNo) {
        ArrayList<StockVo> list= (ArrayList<StockVo>) stockService.getListByProductNo(productNo);
        if(list.size()!=0) return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("fail"));
    }
    /**
     * 해당 재고상품을 보여준다.
     */
    @ApiOperation(value="재고상품 보기")
    @ApiImplicitParam(name="stockNo",value="stockNo",required = true, dataType = "int", paramType = "path", defaultValue = "")
    @GetMapping(value="/{stockNo}")
    public ResponseEntity<JSONResult> getStockByStockNo(@PathVariable int stockNo) {
        StockVo vo= stockService.getStockByStockNo(stockNo);
        if(vo!=null) return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(vo));
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("fail"));
    }

    /**
      *  주문 후 수정되는 상품재고
      */
    @ApiOperation(value="해당 번호의 상품 수정")
    @ApiImplicitParams({
    @ApiImplicitParam(name="상품재고번호",value="stockNo",required = true, dataType = "int", paramType = "path", defaultValue = ""),
    @ApiImplicitParam(name="수량",value="qnty",required = true, dataType = "int", paramType = "query", defaultValue = "")
    })
    @PutMapping(value="/quantity/{stockNo}")
    public ResponseEntity<JSONResult> updateAfterOrder(@PathVariable  int stockNo, @RequestBody int qnty) {
            if(stockService.updateAfterOrder(stockNo,qnty)) return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success("success"));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("fail"));
        }

    /**
     *  상품재고 내용 수정
     */
    @ApiOperation(value="상품재고 내용 수정")
    @ApiImplicitParams({
            @ApiImplicitParam(name="상품재고",value="StockVo",required = true, dataType = "StockVo", paramType = "query", defaultValue = "")
    })
    @PutMapping(value="")
    public ResponseEntity<JSONResult> updateStock(@RequestBody StockVo vo) {
        if(stockService.updateStock(vo)) return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success("success"));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("fail"));
    }
//
//    /**
//     * 해당 번호의 상품을 삭제한다
//     */
//    @ApiOperation(value="해당 번호의 상품 삭제")
//    @ApiImplicitParam(name="no",value="no",required = true, dataType = "int", paramType = "path", defaultValue = "")
//    @DeleteMapping(value="/{no}")
//    public ResponseEntity<JSONResult> deleteProduct(@PathVariable int no) {
//        if(productService.deleteProduct(no)) return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success("success"));
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("fail"));
//    }
//
//
    }


