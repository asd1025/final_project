package com.cafe24.shoppingmall.controller.api;

import com.cafe24.shoppingmall.config.AppConfig;
import com.cafe24.shoppingmall.config.TestWebConfig;
import com.cafe24.shoppingmall.service.ProductService;
import com.cafe24.shoppingmall.vo.*;
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

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, TestWebConfig.class})
@WebAppConfiguration
public class ProductControllerTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private ProductService productService;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Ignore
    @Test
    public void testDIUserService() {
        assertNotNull(productService);
    }

//    @Ignore
    @Test
    public void testRegProduct() throws Exception {

        // 200

        ProductVo productVo=new ProductVo();
        productVo.setName("단가라티셔츠");
        productVo.setContent("단가라를 포인트로 \n" +
                "유니크한 색 조합\n" +

                "여름내내 즐겨주세요!");
        productVo.setMaterial("면, 코튼 (100%)");
        productVo.setPrice(12000);
        productVo.setCountry("중국");
        productVo.setWholesalePrice(7000);
        productVo.setActualPrice(12000);
        productVo.setCategoryNo(2);
        // 사진
        List<PhotoVo> list1 = new ArrayList<>();
        PhotoVo p1=new PhotoVo();
        p1.setPath("/mall/img/c3.jpg");
        p1.setProductNo(3);
        p1.setIsThumb(1);

        PhotoVo p2=new PhotoVo();
        p2.setPath("/mall/img/c1.jpg");
        p2.setProductNo(3);

        list1.add(p1);
        list1.add(p2);

        //옵션
        List<OptionVo> list2 = new ArrayList<>();
        OptionVo op1=new OptionVo();
        op1.setOptionName("색");
        op1.setProductNo(3);
        OptionVo op2=new OptionVo();
        op2.setOptionName("사이즈");
        op2.setProductNo(3);
        list2.add(op1);
        list2.add(op2);

        //옵션디테일
        List<OptionDetailVo> list3 = new ArrayList<>();
        OptionDetailVo opd1=new OptionDetailVo();
        opd1.setOptionNo(1);
        opd1.setDetailName("초록");

        OptionDetailVo opd2=new OptionDetailVo();
        opd2.setDetailName("S");
        opd2.setOptionNo(2);

        list3.add(opd1);
        list3.add(opd2);
        opd2=new OptionDetailVo();
        opd1=new OptionDetailVo();
        opd1.setOptionNo(1);
        opd1.setDetailName("노랑");
        opd2.setDetailName("M");
        opd2.setOptionNo(2);
        list3.add(opd1);
        list3.add(opd2);


        // 상품재고
        List<StockVo> list=new ArrayList<>();
        StockVo stockVo=new StockVo();
        stockVo.setFinalOption("초록/S");
        stockVo.setOptionNums("1/2");
        stockVo.setInstockDate("2019-08-02");
        stockVo.setAmount(40);
        stockVo.setPurchaseCount(10);
        stockVo.setProductNo(3);
        stockVo.setProductCode("ZBDF0111");
        list.add(stockVo);

        stockVo=new StockVo();
        stockVo.setFinalOption("노랑/M");
        stockVo.setOptionNums("3/4");
        stockVo.setInstockDate("2019-08-02");
        stockVo.setAmount(40);
        stockVo.setPurchaseCount(10);
        stockVo.setProductNo(3);
        stockVo.setProductCode("ZBDF0112");
        list.add(stockVo);

        productVo.setPhotos(list1);
        productVo.setOptions(list2);
        productVo.setOptionDetails(list3);
        productVo.setStocks(list);


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
                .perform(get("/api/product/{no}",3).contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isOk()).andDo(print())
                .andExpect(jsonPath("$.result", is("success")));

        // 400
        resultActions = mockMvc
                .perform(get("/api/product/{id}",100).contentType(MediaType.APPLICATION_JSON));

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
