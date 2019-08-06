package com.cafe24.shoppingmall.controller.api.admin;

import com.cafe24.shoppingmall.config.AppConfig;
import com.cafe24.shoppingmall.config.TestWebConfig;
import com.cafe24.shoppingmall.service.OrdersService;
import com.cafe24.shoppingmall.vo.OrdersVo;
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

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, TestWebConfig.class})
@WebAppConfiguration
public class AdminOrdersControllerTest {
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
        public void testGetAllOrders() throws Exception {

            // 200
            ResultActions resultActions = mockMvc
                    .perform(get("/api/admin/orders").contentType(MediaType.APPLICATION_JSON));

            resultActions.andExpect(status().isOk()).andDo(print())
                    .andExpect(jsonPath("$.result", is("success")));

        }

    @Test
    public void testUpdateOrders() throws Exception {

        // 200
        OrdersVo vo=new OrdersVo();
        vo.setCode("20190725-00000002");
        vo.setOrderProcessStatus("주문접수");
        vo.setOrderShippingStatus("배송대기");
        ResultActions resultActions = mockMvc
                .perform(post("/api/admin/orders").contentType(MediaType.APPLICATION_JSON)
                        .content(new Gson().toJson(vo)));

        resultActions.andExpect(status().isOk()).andDo(print())
                .andExpect(jsonPath("$.result", is("success")));

//
        // 400 존재하지 않은 주문번호
        vo=new OrdersVo();
        vo.setOrderProcessStatus("주문접수");
        vo.setOrderShippingStatus("배송대기");
        resultActions = mockMvc
                .perform(post("/api/orders/nonmember").contentType(MediaType.APPLICATION_JSON)
                        .content(new Gson().toJson(vo)));

        resultActions.andExpect(status().isBadRequest()).andDo(print())
                .andExpect(jsonPath("$.result", is("fail")));


    }

//        @Ignore
        @Test
        public void testDeleteOrdersByCode() throws Exception {

            // 200

            ResultActions resultActions = mockMvc
                    .perform(delete("/api/admin/orders/{code}","20190726-00000001").contentType(MediaType.APPLICATION_JSON));
            resultActions.andExpect(status().isOk()).andDo(print())
                    .andExpect(jsonPath("$.result", is("success")));
            // 400 존재하지 않는 주문코드
        resultActions = mockMvc
                .perform(delete("/api/admin/orders/{code}","20190726-000000221").contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isBadRequest()).andDo(print())
                .andExpect(jsonPath("$.result", is("fail")));


        }
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


}
