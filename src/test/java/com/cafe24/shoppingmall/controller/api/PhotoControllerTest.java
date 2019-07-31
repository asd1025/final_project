package com.cafe24.shoppingmall.controller.api;

import com.cafe24.shoppingmall.config.AppConfig;
import com.cafe24.shoppingmall.config.TestWebConfig;
import com.cafe24.shoppingmall.service.OptionDetailService;
import com.cafe24.shoppingmall.service.PhotoService;
import com.cafe24.shoppingmall.vo.OptionDetailVo;
import com.cafe24.shoppingmall.vo.PhotoVo;
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
public class PhotoControllerTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private PhotoService photoService;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

//    @Ignore
    @Test
    public void testDIOPhotoService() {
        assertNotNull(photoService);
    }

//    @Ignore
    @Test
    public void testRegPhotos() throws Exception {

        // 200
        List<PhotoVo> list = new ArrayList<>();
        PhotoVo p1=new PhotoVo();
        p1.setPath("/mall/img/a3.jpg");
        p1.setProductNo(1);
        p1.setIsThumb(true);

        PhotoVo p2=new PhotoVo();
        p2.setPath("/mall/img/a1.jpg");
        p2.setProductNo(2);

        list.add(p1);
        list.add(p2);

        ResultActions resultActions = mockMvc
                .perform(post("/api/photo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new Gson().toJson(list)));

        resultActions.andExpect(status().isOk()).andDo(print()).
                andExpect(jsonPath("$.result", is("success")));

        //400 null일 경우
        list = new ArrayList<>();

          resultActions = mockMvc
                .perform(post("/api/photo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new Gson().toJson(list)));

        resultActions.andExpect(status().isBadRequest()).andDo(print()).
                andExpect(jsonPath("$.result", is("fail")));



    }
//
//    @Ignore
    @Test
    public void testGetAllPhotosByProductNo() throws Exception {
        // 200
        ResultActions resultActions = mockMvc
                .perform(get("/api/photo/{productNo}",1).contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isOk()).andDo(print())
                .andExpect(jsonPath("$.result", is("success")));

        // 400 존재하지 않는 상품 번호
         resultActions = mockMvc
                .perform(get("/api/photo/{productNo}",10).contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isBadRequest()).andDo(print())
                .andExpect(jsonPath("$.result", is("fail")));
    }

    @Test
    public void testUpdatePhotos() throws Exception {

        // 200
        OptionDetailVo vo=new OptionDetailVo();
        vo.setNo(13);
        vo.setDetailName("회색");
        List<PhotoVo> list = new ArrayList<>();
        PhotoVo p1=new PhotoVo();
        p1.setPath("/mall/img/a4.jpg");
        p1.setProductNo(1);
        p1.setIsThumb(true);

        PhotoVo p2=new PhotoVo();
        p2.setPath("/mall/img/a4.jpg");
        p2.setProductNo(1);

        list.add(p1);
        list.add(p2);

        ResultActions  resultActions = mockMvc
                .perform(put("/api/photo/{productNo}",1) .contentType(MediaType.APPLICATION_JSON)
                        .content(new Gson().toJson(list)));

        resultActions.andExpect(status().isOk()).andDo(print())
                .andExpect(jsonPath("$.result", is("success")));

        //400 null일 경우
        list = new ArrayList<>();

        resultActions = mockMvc
                .perform(put("/api/photo/{productNo}",1) .contentType(MediaType.APPLICATION_JSON)
                        .content(new Gson().toJson(list)));

        resultActions.andExpect(status().isBadRequest()).andDo(print()).
                andExpect(jsonPath("$.result", is("fail")));

        // 400 존재하지 않는 상품 번호일떄
        list = new ArrayList<>();

        resultActions = mockMvc
                .perform(put("/api/photo/{productNo}",100) .contentType(MediaType.APPLICATION_JSON)
                        .content(new Gson().toJson(list)));

        resultActions.andExpect(status().isBadRequest()).andDo(print()).
                andExpect(jsonPath("$.result", is("fail")));

    }

    @Test
    public void testDeletePhotos() throws Exception {

        // 200
        ResultActions resultActions = mockMvc
                .perform(delete("/api/photo/{productNo}",1).contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isOk()).andDo(print())
                .andExpect(jsonPath("$.result", is("success")));

        // 400
        resultActions = mockMvc
                .perform(delete("/api/photo/{productNo}",100).contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isBadRequest()).andDo(print())
                .andExpect(jsonPath("$.result", is("fail")));

    }

}
