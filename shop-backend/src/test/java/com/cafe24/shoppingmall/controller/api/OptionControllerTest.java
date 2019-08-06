package com.cafe24.shoppingmall.controller.api;

import com.cafe24.shoppingmall.config.AppConfig;
import com.cafe24.shoppingmall.config.TestWebConfig;
import com.cafe24.shoppingmall.service.OptionService;
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
public class OptionControllerTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private OptionService optionService;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Ignore
    @Test
    public void testDIOptionService() {
        assertNotNull(optionService);
    }

//    @Ignore
    @Test
    public void testAddOption() throws Exception {

        // 200
        List<OptionVo> list = new ArrayList<>();
        OptionVo op1=new OptionVo();
        op1.setOptionName("색");
        op1.setProductNo(1);
        OptionVo op2=new OptionVo();
        op2.setOptionName("사이즈");
        op2.setProductNo(1);
        list.add(op1);
        list.add(op2);

        ResultActions resultActions = mockMvc
                .perform(post("/api/option")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new Gson().toJson(list)));

        resultActions.andExpect(status().isOk()).andDo(print()).
                andExpect(jsonPath("$.result", is("success")));

        //400
//        List<OptionVo> list = new ArrayList<>();
//
//        ResultActions        resultActions = mockMvc
//                .perform(post("/api/option")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(new Gson().toJson(list)));
//
//        resultActions.andExpect(status().isBadRequest()).andDo(print()).
//                andExpect(jsonPath("$.result", is("fail")));

    }

//    @Ignore
    @Test
    public void testGetAllOption() throws Exception {
        // 200
        ResultActions resultActions = mockMvc
                .perform(get("/api/option").contentType(MediaType.APPLICATION_JSON));

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
    public void testGetOptionByNo() throws Exception {
        // 200
        ResultActions resultActions = mockMvc
                .perform(get("/api/option/{no}",3).contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isOk()).andDo(print())
                .andExpect(jsonPath("$.result", is("success")));

        // 400
         resultActions = mockMvc
                .perform(get("/api/option/{no}",100).contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isBadRequest()).andDo(print())
                .andExpect(jsonPath("$.result", is("fail")));


    }

    @Test
    public void testGetOptionByProductNo() throws Exception {
        // 200
        ResultActions resultActions = mockMvc
                .perform(get("/api/option/product/{no}",1).contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isOk()).andDo(print())
                .andExpect(jsonPath("$.result", is("success")));

        // 400
        resultActions = mockMvc
                .perform(get("/api/option/product/{no}",100).contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isBadRequest()).andDo(print())
                .andExpect(jsonPath("$.result", is("fail")));


    }

//    @Ignore
    @Test
    public void testDeleteOptionByNo() throws Exception {

        // 200
        ResultActions resultActions = mockMvc
                .perform(delete("/api/option/{no}",4).contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isOk()).andDo(print())
                .andExpect(jsonPath("$.result", is("success")));

        // 400
     resultActions = mockMvc
                .perform(delete("/api/option/{no}",100).contentType(MediaType.APPLICATION_JSON));

      resultActions.andExpect(status().isBadRequest()).andDo(print())
                .andExpect(jsonPath("$.result", is("fail")));

    }
    @Test
    public void testDeleteOptionByProductNo() throws Exception {

        // 200
        ResultActions resultActions = mockMvc
                .perform(delete("/api/option/product/{no}",3).contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isOk()).andDo(print())
                .andExpect(jsonPath("$.result", is("success")));

        // 400
        resultActions = mockMvc
                .perform(delete("/api/option/product/{no}",100).contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isBadRequest()).andDo(print())
                .andExpect(jsonPath("$.result", is("fail")));

    }

    @Test
    public void testUpdateCart() throws Exception {


        // 200
        OptionVo optionVo = new OptionVo();
        optionVo.setOptionName("SIZE");
        optionVo.setOptionNo(4);

        ResultActions  resultActions = mockMvc
                .perform(put("/api/option") .contentType(MediaType.APPLICATION_JSON)
                        .content(new Gson().toJson(optionVo)));

        resultActions.andExpect(status().isOk()).andDo(print())
                .andExpect(jsonPath("$.result", is("success")));

        // 400
        optionVo = new OptionVo();
        optionVo.setOptionNo(100);
         resultActions = mockMvc
                .perform(put("/api/option").contentType(MediaType.APPLICATION_JSON)
                        .content(new Gson().toJson(optionVo)));

        resultActions.andExpect(status().isBadRequest()).andDo(print())
                .andExpect(jsonPath("$.result", is("fail")));


    }

}
