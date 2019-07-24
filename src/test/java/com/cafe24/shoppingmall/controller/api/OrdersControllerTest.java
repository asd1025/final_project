package com.cafe24.shoppingmall.controller.api;

import com.cafe24.shoppingmall.config.AppConfig;
import com.cafe24.shoppingmall.config.TestWebConfig;
import com.cafe24.shoppingmall.service.OrdersService;
import com.cafe24.shoppingmall.service.ProductService;
import com.cafe24.shoppingmall.vo.ProductVo;
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

//    @Ignore
    @Test
    public void testRegProduct() throws Exception {

        // 200
        ProductVo productVo=new ProductVo();
        productVo.setName("HBB반팔티셔츠2");
        productVo.setContent("배색컬러 포인트로~~~~~~~~\n" +
                "유니크한 슬림반팔티\n" +

                "여름내내 즐겨주세요!");
        productVo.setMaterial("면, 코튼 (100%)");
        productVo.setPrice(14000);
        productVo.setCountry("중국");
        productVo.setWholesalePrice(8000);
        productVo.setActualPrice(9000);
        productVo.setCategoryNo(2);


        ResultActions resultActions = mockMvc
                .perform(post("/api/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new Gson().toJson(productVo)));

        resultActions.andExpect(status().isOk()).andDo(print()).
                andExpect(jsonPath("$.result", is("success")));
    }
//    @Ignore
    @Test
    public void testGetProductList() throws Exception {

        // 200
        ResultActions resultActions = mockMvc
                .perform(get("/api/product").contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isOk()).andDo(print())
                .andExpect(jsonPath("$.result", is("success")));


    }
//    @Ignore
    @Test
    public void testGetProductByNo() throws Exception {

        //200
        ResultActions resultActions = mockMvc
                .perform(get("/api/product/{no}",1).contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isOk()).andDo(print())
                .andExpect(jsonPath("$.result", is("success")));

        // 400
        resultActions = mockMvc
                .perform(get("/api/product/{id}",5).contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isBadRequest()).andDo(print())
                .andExpect(jsonPath("$.result", is("fail")));
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

    @Test
    public void testUpdateCartProduct() throws Exception {

        ProductVo productVo=new ProductVo();
        productVo.setProductNo(3);
        productVo.setName("HBB반팔티셔츠");
        productVo.setContent("배색컬러 포인트로!!!!!!\n" +
                "유니크한 슬림반팔티\n" +
                "MD COMMENT \n" +
                "───────────────────\n" +
                "유니크한 무드의 배색컬러 티셔츠에요:)\n" +
                "라인이 예쁘게 드러나는 슬림한 핏이구요\n" +
                "포인트 있는 배색된 컬러들로 제작되어\n" +
                "유니크한 느낌이 물씬 느껴진답니다-!\n" +
                "모델처럼 데님와이드팬츠와\n" +
                "매치해주셔도 좋구요\n" +
                "숏팬츠,스커트에 매치해도 잘 어울려요!\n" +
                "신축성이 좋아 편안하게 착용되어\n" +
                "여름내내 즐겨주세요!");
        productVo.setMaterial("면, 코튼 (100%)");
        productVo.setPrice(14000);
        productVo.setCountry("중국");
        productVo.setWholesalePrice(8000);
        productVo.setActualPrice(9000);
        productVo.setCategoryNo(2);

        // 200
        ResultActions resultActions = mockMvc
                .perform(put("/api/product") .contentType(MediaType.APPLICATION_JSON)
                        .content(new Gson().toJson(productVo)));

        resultActions.andExpect(status().isOk()).andDo(print())
                .andExpect(jsonPath("$.result", is("success")));

        // 400
//        resultActions = mockMvc
//                .perform(put("/api/product/{no}") .contentType(MediaType.APPLICATION_JSON)
//                        .content(new Gson().toJson(productVo)));
//
//        resultActions.andExpect(status().isBadRequest()).andDo(print())
//                .andExpect(jsonPath("$.result", is("fail")));


    }

}
