package com.cafe24.shoppingmall.controller.api;

import com.cafe24.shoppingmall.config.AppConfig;
import com.cafe24.shoppingmall.config.TestWebConfig;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import com.cafe24.shoppingmall.service.CartService;
import com.cafe24.shoppingmall.vo.CartVo;
import com.cafe24.shoppingmall.vo.StockVo;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.web.servlet.MockMvc;

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
public class CartControllerTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private CartService cartService;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Ignore
    @Test
    public void testDICartService() {
        assertNotNull(cartService);
    }

//    @Ignore
    @Test
    public void testAddCart() throws Exception {

        // 200
        CartVo cartVo = new CartVo();
        cartVo.setId("asd4");
        cartVo.setQuantity(1);
        cartVo.setStockNo(4);


        ResultActions resultActions = mockMvc
                .perform(post("/api/cart")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new Gson().toJson(cartVo)));

        resultActions.andExpect(status().isOk()).andDo(print()).
                andExpect(jsonPath("$.result", is("success")));
          cartVo = new CartVo();
        cartVo.setId("asd4");
        cartVo.setQuantity(2);
        cartVo.setStockNo(3);


          resultActions = mockMvc
                .perform(post("/api/cart")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new Gson().toJson(cartVo)));

        resultActions.andExpect(status().isOk()).andDo(print()).
                andExpect(jsonPath("$.result", is("success")));
        // 400

//        resultActions = mockMvc
//                .perform(post("/api/cart")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(new Gson().toJson(new CartVo())));
//
//        resultActions.andExpect(status().isBadRequest()).andDo(print()).
//                andExpect(jsonPath("$.result", is("fail")));


    }

    @Ignore
    @Test
    public void testShowCart() throws Exception {

        // 200
        ResultActions resultActions = mockMvc
                .perform(get("/api/cart/{id}","asd4").contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isOk()).andDo(print())
                .andExpect(jsonPath("$.result", is("success")));

        // 400
         resultActions = mockMvc
                .perform(get("/api/cart/{id}","user2").contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isBadRequest()).andDo(print())
                .andExpect(jsonPath("$.result", is("fail")));


    }

    @Ignore
    @Test
    public void testDeleteCartProduct() throws Exception {

        // 200
        ResultActions resultActions = mockMvc
                .perform(delete("/api/cart/{id}/{stock_no}","asd2",4).contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isOk()).andDo(print())
                .andExpect(jsonPath("$.result", is("success")));

        // 400
//        resultActions = mockMvc
//                .perform(delete("/api/cart/{id}/{no}","user2",2).contentType(MediaType.APPLICATION_JSON));
//
//        resultActions.andExpect(status().isBadRequest()).andDo(print())
//                .andExpect(jsonPath("$.result", is("fail")));


    }
//    @Ignore
    @Test
    public void testDeleteCart() throws Exception {

        // 200
        ResultActions resultActions = mockMvc
                .perform(delete("/api/cart/{id}","asd4").contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isOk()).andDo(print())
                .andExpect(jsonPath("$.result", is("success")));

        // 400
//         resultActions = mockMvc
//                .perform(delete("/api/cart/{id}","user2").contentType(MediaType.APPLICATION_JSON));
//
//        resultActions.andExpect(status().isBadRequest()).andDo(print())
//                .andExpect(jsonPath("$.result", is("fail")));


    }
}
