package com.cafe24.shoppingmall.controller.api;

import com.cafe24.shoppingmall.config.AppConfig;
import com.cafe24.shoppingmall.config.TestWebConfig;
import com.cafe24.shoppingmall.service.StockService;
import com.cafe24.shoppingmall.vo.StockVo;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, TestWebConfig.class})
@WebAppConfiguration
public class StockControllerTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private StockService stockService;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testDIUserService() {
        assertNotNull(stockService);
    }

//    @Ignore
    @Test
    public void testRegStock() throws Exception {
        List<StockVo> list=new ArrayList<>();

        // 200
        StockVo stockVo=new StockVo();
        stockVo.setFinalOption("빨강/XL");
        stockVo.setOptionNums("3/2");
        stockVo.setInstockDate("2019-07-01");
        stockVo.setAmount(40);
        stockVo.setPurchaseCount(10);
        stockVo.setProductNo(1);
        stockVo.setProductCode("ZBTA0111");
        list.add(stockVo);

        stockVo=new StockVo();
        stockVo.setFinalOption("초록/S");
        stockVo.setOptionNums("5/6");
        stockVo.setInstockDate("2019-07-01");
        stockVo.setAmount(40);
        stockVo.setPurchaseCount(10);
        stockVo.setProductNo(1);
        stockVo.setProductCode("ZBTA0111");
        list.add(stockVo);


        ResultActions resultActions = mockMvc
                .perform(post("/api/stock")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new Gson().toJson(list)));

        resultActions.andExpect(status().isOk()).andDo(print()).
                andExpect(jsonPath("$.result", is("success")));
    }
//    @Ignore
    @Test
    public void testGetListByProductNo() throws Exception {

        // 200
        ResultActions resultActions = mockMvc
                .perform(get("/api/stock/product/{productNo}",1).contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isOk()).andDo(print())
                .andExpect(jsonPath("$.result", is("success")));

        // 400
        resultActions = mockMvc
                .perform(get("/api/stock/product/{productNo}",100).contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isBadRequest()).andDo(print())
                .andExpect(jsonPath("$.result", is("fail")));


    }
//    @Ignore
    @Test
    public void testGetStockByStockNo() throws Exception {

        //200
        ResultActions resultActions = mockMvc
                .perform(get("/api/stock/{stockNo}",1).contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isOk()).andDo(print())
                .andExpect(jsonPath("$.result", is("success")));

        // 400
        resultActions = mockMvc
                .perform(get("/api/stock/{stockNo}",100).contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isBadRequest()).andDo(print())
                .andExpect(jsonPath("$.result", is("fail")));
    }
    @Test
    public void testUpdateAfterOrder() throws Exception {

        int qnty =2;

        // 200
        ResultActions resultActions = mockMvc
                .perform(put("/api/stock/quantity/{stockNo}",1) .contentType(MediaType.APPLICATION_JSON)
                        .content(new Gson().toJson(qnty)));

        resultActions.andExpect(status().isOk()).andDo(print())
                .andExpect(jsonPath("$.result", is("success")));

        // 400 존재하지 않는 상품재고번호
        resultActions = mockMvc
                .perform(put("/api/stock/quantity/{stockNo}",100) .contentType(MediaType.APPLICATION_JSON)
                        .content(new Gson().toJson(qnty)));

        resultActions.andExpect(status().isBadRequest()).andDo(print())
                .andExpect(jsonPath("$.result", is("fail")));

        //400 재고 수량보다 초과하는 수량을 주문하는 경우
        qnty=100;
        resultActions = mockMvc
                .perform(put("/api/stock/quantity/{stockNo}",1) .contentType(MediaType.APPLICATION_JSON)
                        .content(new Gson().toJson(qnty)));

        resultActions.andExpect(status().isBadRequest()).andDo(print())
                .andExpect(jsonPath("$.result", is("fail")));

    }
    @Test
    public void testUpdate() throws Exception {
        StockVo vo=new StockVo();
        vo.setStockNo(5);
        vo.setFinalOption("초록/S");
        vo.setOptionNums("5/6");
        vo.setInstockDate("2019-08-01");
        vo.setAmount(20);
        vo.setPurchaseCount(20);
        vo.setProductNo(1);
        vo.setOptionPrice(3000);
        vo.setProductCode("ZBTA0225");
        vo.setThumbImg("/mall/img/b3.jpg");

        // 200
        ResultActions resultActions = mockMvc
                .perform(put("/api/stock") .contentType(MediaType.APPLICATION_JSON)
                        .content(new Gson().toJson(vo)));

        resultActions.andExpect(status().isOk()).andDo(print())
                .andExpect(jsonPath("$.result", is("success")));

        // 400 존재하지 않는 상품재고번호
//        resultActions = mockMvc
//                .perform(put("/api/stock") .contentType(MediaType.APPLICATION_JSON)
//                        .content(new Gson().toJson(vo)));
//
//        resultActions.andExpect(status().isBadRequest()).andDo(print())
//                .andExpect(jsonPath("$.result", is("fail")));
    }
//    @Ignore
    @Test
    public void testDeleteCartProduct() throws Exception {

        // 200
        ResultActions resultActions = mockMvc
                .perform(delete("/api/product/{no}",4).contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isOk()).andDo(print())
                .andExpect(jsonPath("$.result", is("success")));

        // 400
        resultActions = mockMvc
                .perform(delete("/api/product/{no}",7).contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isBadRequest()).andDo(print())
                .andExpect(jsonPath("$.result", is("fail")));


    }
//
//

}
