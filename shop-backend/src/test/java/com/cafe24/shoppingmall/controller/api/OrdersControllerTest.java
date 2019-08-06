package com.cafe24.shoppingmall.controller.api;

import com.cafe24.shoppingmall.config.AppConfig;
import com.cafe24.shoppingmall.config.TestWebConfig;
import com.cafe24.shoppingmall.service.CartService;
import com.cafe24.shoppingmall.service.OrdersService;
import com.cafe24.shoppingmall.util.CodeMaker;
import com.cafe24.shoppingmall.vo.CartVo;
import com.cafe24.shoppingmall.vo.OrdersVo;
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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, TestWebConfig.class})
@WebAppConfiguration
public class OrdersControllerTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private OrdersService ordersService;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

//    @Ignore
    @Test
    public void testDIOrdersService() {
        assertNotNull(ordersService);
    }

        @Test
        public void testAddCart() throws Exception {

            // 200 회원 주문
            OrdersVo vo = new OrdersVo();
            vo.setSendName("김가나");
            vo.setSendZipcode("06208");
            vo.setSendAddress("서울시 강남구 도곡로 11길 11 101호");
            vo.setSendPhone("010-2223-2323");
            vo.setSendEmail("asdf@naver.com");
            vo.setRecipientName("원빈");
            vo.setRecipientZipcode("09255");
            vo.setRecipientAddress("서울시 강남구 삼성로 22길 22");
            vo.setMessage("부재시 문앞이요");
            vo.setId("asd1");
            vo.setTotalPurchasePrice(13000);
            vo.setTotalActualPayment(12000);
//            vo.setCode(CodeMaker.makeCode());

            ResultActions resultActions = mockMvc
                    .perform(post("/api/orders")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(new Gson().toJson(vo)));

            resultActions.andExpect(status().isOk()).andDo(print()).
                    andExpect(jsonPath("$.result", is("success")));

            // 200 비회원 주문
            vo = new OrdersVo();
            vo.setSendName("김우빈");
            vo.setSendZipcode("06111");
            vo.setSendAddress("서울시 강남구 선릉로 43길 33");
            vo.setSendPhone("010-1111-3333");
            vo.setSendEmail("frfr@naver.com");
            vo.setRecipientName("이종석");
            vo.setRecipientZipcode("434333");
            vo.setRecipientAddress("서울시 강남구 언주로 44길 11");
            vo.setMessage("부재시 문앞이요!!!");
//            vo.setId("20190724-1");
            vo.setTotalPurchasePrice(13000);
            vo.setTotalActualPayment(12000);
//            vo.setCode(CodeMaker.makeCode());

            vo.setOrderPassword("asdasd");


            resultActions = mockMvc
                    .perform(post("/api/orders")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(new Gson().toJson(vo)));

            resultActions.andExpect(status().isOk()).andDo(print()).
                    andExpect(jsonPath("$.result", is("success")));
//
//
            // 400 비회원 주문시 비밀번호 invalid
            vo = new OrdersVo();
            vo.setSendName("김우빈");
            vo.setSendZipcode("06111");
            vo.setSendAddress("서울시 강남구 선릉로 43길 33");
            vo.setSendPhone("010-1111-3333");
            vo.setSendEmail("frfr@naver.com");
            vo.setRecipientName("이종석");
            vo.setRecipientZipcode("434333");
            vo.setRecipientAddress("서울시 강남구 언주로 44길 11");
            vo.setMessage("부재시 문앞이요!!!");
            vo.setTotalPurchasePrice(13000);
            vo.setTotalActualPayment(12000);

            vo.setOrderPassword("asd");

                    resultActions = mockMvc
                            .perform(post("/api/orders")
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(new Gson().toJson(vo)));

                    resultActions.andExpect(status().isBadRequest()).andDo(print()).
                            andExpect(jsonPath("$.result", is("fail")));


        }

//    @Ignore
        @Test
        public void testGetAllOrdersById() throws Exception {

            // 200
            ResultActions resultActions = mockMvc
                    .perform(get("/api/orders/{id}","asd1").contentType(MediaType.APPLICATION_JSON));

            resultActions.andExpect(status().isOk()).andDo(print())
                    .andExpect(jsonPath("$.result", is("success")));

//             400 존재하지 않는 회원
            resultActions = mockMvc
                    .perform(get("/api/orders/{id}","user2").contentType(MediaType.APPLICATION_JSON));

            resultActions.andExpect(status().isBadRequest()).andDo(print())
                    .andExpect(jsonPath("$.result", is("fail")));


        }
        @Test
        public void testGetOrdersByNonmember() throws Exception {

            // 200
            OrdersVo vo=new OrdersVo();
            vo.setCode("20190725-00000002");
            vo.setOrderPassword("asdasd");
            ResultActions resultActions = mockMvc
                    .perform(post("/api/orders/nonmember").contentType(MediaType.APPLICATION_JSON)
                    .content(new Gson().toJson(vo)));

            resultActions.andExpect(status().isOk()).andDo(print())
                    .andExpect(jsonPath("$.result", is("success")));

//           // 400 일치하지 않는 비밀번호
            vo=new OrdersVo();
            vo.setCode("20190725-00000002");
            vo.setOrderPassword("aaaaaaa");
            resultActions = mockMvc
                    .perform(post("/api/orders/nonmember").contentType(MediaType.APPLICATION_JSON)
                            .content(new Gson().toJson(vo)));

            resultActions.andExpect(status().isBadRequest()).andDo(print())
                    .andExpect(jsonPath("$.result", is("fail")));

            // 400 존재하지 않은 주문번호
            vo=new OrdersVo();
            vo.setCode("20190725-00000222");
            vo.setOrderPassword("aaaaaaa");
            resultActions = mockMvc
                    .perform(post("/api/orders/nonmember").contentType(MediaType.APPLICATION_JSON)
                            .content(new Gson().toJson(vo)));

            resultActions.andExpect(status().isBadRequest()).andDo(print())
                    .andExpect(jsonPath("$.result", is("fail")));

        }
//
//        @Ignore
//        @Test
//        public void testDeleteCartProduct() throws Exception {
//
//            // 200
//            ResultActions resultActions = mockMvc
//                    .perform(delete("/api/cart/{id}/{stock_no}","asd2",4).contentType(MediaType.APPLICATION_JSON));
//
//            resultActions.andExpect(status().isOk()).andDo(print())
//                    .andExpect(jsonPath("$.result", is("success")));
//
//            // 400
////        resultActions = mockMvc
////                .perform(delete("/api/cart/{id}/{no}","user2",2).contentType(MediaType.APPLICATION_JSON));
////
////        resultActions.andExpect(status().isBadRequest()).andDo(print())
////                .andExpect(jsonPath("$.result", is("fail")));
//
//
//        }
////    @Ignore
//        @Test
//        public void testDeleteCart() throws Exception {
//
//            // 200
//            ResultActions resultActions = mockMvc
//                    .perform(delete("/api/cart/{id}","asd4").contentType(MediaType.APPLICATION_JSON));
//
//            resultActions.andExpect(status().isOk()).andDo(print())
//                    .andExpect(jsonPath("$.result", is("success")));
//
//            // 400
////         resultActions = mockMvc
////                .perform(delete("/api/cart/{id}","user2").contentType(MediaType.APPLICATION_JSON));
////
////        resultActions.andExpect(status().isBadRequest()).andDo(print())
////                .andExpect(jsonPath("$.result", is("fail")));
//
//
//        }
//
//        @Test
//        public void testUpdateCart() throws Exception {
//
//
//            // 200
//            CartVo cartVo = new CartVo();
//            cartVo.setId("asd4");
//            cartVo.setStockNo(3);
//            cartVo.setQuantity(7);
//
//
//
//        }

}
