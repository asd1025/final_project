package com.cafe24.shoppingmall.controller.api;

import com.cafe24.shoppingmall.config.AppConfig;
import com.cafe24.shoppingmall.config.TestWebConfig;
import com.cafe24.shoppingmall.service.OptionDetailService;
import com.cafe24.shoppingmall.service.OptionService;
import com.cafe24.shoppingmall.vo.OptionDetailVo;
import com.cafe24.shoppingmall.vo.OptionVo;
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
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, TestWebConfig.class})
@WebAppConfiguration
public class OptionDetailControllerTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private OptionDetailService optionDetailService;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

//    @Ignore
    @Test
    public void testDIOptionDetailService() {
        assertNotNull(optionDetailService);
    }

//    @Ignore
    @Test
    public void testAddOptionDetail() throws Exception {

        // 200
        List<OptionDetailVo> list = new ArrayList<>();
        OptionDetailVo op1=new OptionDetailVo();
        op1.setOptionNo(1);
        op1.setDetailName("빨강");

        OptionDetailVo op2=new OptionDetailVo();
        op2.setDetailName("L");
        op2.setOptionNo(2);

        list.add(op1);
        list.add(op2);

        ResultActions resultActions = mockMvc
                .perform(post("/api/detail")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new Gson().toJson(list)));

        resultActions.andExpect(status().isOk()).andDo(print()).
                andExpect(jsonPath("$.result", is("success")));

        //400 null일 경우
        list = new ArrayList<>();

          resultActions = mockMvc
                .perform(post("/api/detail")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new Gson().toJson(list)));

        resultActions.andExpect(status().isBadRequest()).andDo(print()).
                andExpect(jsonPath("$.result", is("fail")));



    }
//
//    @Ignore
    @Test
    public void testGetAllOptionDetail() throws Exception {
        // 200
        ResultActions resultActions = mockMvc
                .perform(get("/api/detail").contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isOk()).andDo(print())
                .andExpect(jsonPath("$.result", is("success")));

        // 400
//         resultActions = mockMvc
//                .perform(get("/api/option").contentType(MediaType.APPLICATION_JSON));
//
//        resultActions.andExpect(status().isBadRequest()).andDo(print())
//                .andExpect(jsonPath("$.result", is("fail")));


    }
    @Test
    public void testGetAllOptionDetailByOptionNo() throws Exception {
        // 200
        ResultActions resultActions = mockMvc
                .perform(get("/api/detail/option/{no}",3).contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isOk()).andDo(print())
                .andExpect(jsonPath("$.result", is("success")));

        // 400
         resultActions = mockMvc
                .perform(get("/api/detail/option/{no}",100).contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isBadRequest()).andDo(print())
                .andExpect(jsonPath("$.result", is("fail")));


    }
    @Test
    public void testGetOptionDetailByNo() throws Exception {
        // 200
        ResultActions resultActions = mockMvc
                .perform(get("/api/detail/{no}",3).contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isOk()).andDo(print())
                .andExpect(jsonPath("$.result", is("success")));

        // 400
         resultActions = mockMvc
                .perform(get("/api/detail/{no}",100).contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isBadRequest()).andDo(print())
                .andExpect(jsonPath("$.result", is("fail")));


    }


    //    @Ignore
        @Test
        public void testDeleteOptionDetailByNo() throws Exception {

            // 200
            ResultActions resultActions = mockMvc
                    .perform(delete("/api/detail/{no}",5).contentType(MediaType.APPLICATION_JSON));

            resultActions.andExpect(status().isOk()).andDo(print())
                    .andExpect(jsonPath("$.result", is("success")));

            // 400
         resultActions = mockMvc
                    .perform(delete("/api/detail/{no}",100).contentType(MediaType.APPLICATION_JSON));

          resultActions.andExpect(status().isBadRequest()).andDo(print())
                    .andExpect(jsonPath("$.result", is("fail")));

        }
    @Test
    public void testDeleteDetailOptionByOptionNo() throws Exception {

        // 200
        ResultActions resultActions = mockMvc
                .perform(delete("/api/detail/option/{no}",3).contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isOk()).andDo(print())
                .andExpect(jsonPath("$.result", is("success")));

        // 400
        resultActions = mockMvc
                .perform(delete("/api/detail/option/{no}",100).contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isBadRequest()).andDo(print())
                .andExpect(jsonPath("$.result", is("fail")));

    }

    @Test
    public void testUpdateDetailOption() throws Exception {


        // 200
        OptionDetailVo vo=new OptionDetailVo();
        vo.setNo(13);
        vo.setDetailName("회색");


        ResultActions  resultActions = mockMvc
                .perform(put("/api/detail") .contentType(MediaType.APPLICATION_JSON)
                        .content(new Gson().toJson(vo)));

        resultActions.andExpect(status().isOk()).andDo(print())
                .andExpect(jsonPath("$.result", is("success")));

        // 400
//        vo=new OptionDetailVo();
//         resultActions = mockMvc
//                .perform(put("/api/detail").contentType(MediaType.APPLICATION_JSON)
//                        .content(new Gson().toJson(vo)));
//
//        resultActions.andExpect(status().isBadRequest()).andDo(print())
//                .andExpect(jsonPath("$.result", is("fail")));


    }

}
