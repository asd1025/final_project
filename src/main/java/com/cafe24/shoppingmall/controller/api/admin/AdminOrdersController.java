package com.cafe24.shoppingmall.controller.api.admin;

import com.cafe24.shoppingmall.dto.JSONResult;
import com.cafe24.shoppingmall.service.OrdersService;
import com.cafe24.shoppingmall.vo.OrdersVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RestController("adminAPIController")
@RequestMapping("/api/admin/orders")
class AdminOrdersController {
    @Autowired
    OrdersService ordersService;

    /**
     * ROLE_ADMIN
     * 회원들 주문 정보를 다 보여준다.
     */
    @ApiOperation(value="회원들 주문 전체 보기")
    @GetMapping(value="")
    public ResponseEntity<JSONResult> showCart() {
        ArrayList<OrdersVo> list= (ArrayList<OrdersVo>) ordersService.getList();
        if(list.size()!=0) return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(list));
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("fail"));
    }
    /**
     * ROLE_ADMIN
     * 회원의 주문상태를 수정한다
     */
    @ApiOperation(value="회원 주문 상태 수정")
    @ApiImplicitParam(name = "ordersVo", value = "주문 객체", required = true, dataType = "OrdersVo", paramType = "query", defaultValue = "")
    @PostMapping(value="")
    public ResponseEntity<JSONResult> updateOrders(@RequestBody OrdersVo vo) {
        boolean isAble=  ordersService.update(vo);
        if(isAble) return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(vo));
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("fail"));
    }
    /**
     * ROLE_ADMIN
     * 회원의 주문을 삭제한다
     */
    @ApiOperation(value="회원 주문 삭제")
    @ApiImplicitParam(name = "code", value = "주문 코드", required = true, dataType = "string", paramType = "path", defaultValue = "")
    @DeleteMapping(value="/{code}")
    public ResponseEntity<JSONResult> deleteOrders(@PathVariable String code) {
        boolean isAble=  ordersService.deleteOrder(code);
        if(isAble) return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(code));
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("fail"));
    }


}
