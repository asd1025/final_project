package com.cafe24.shoppingmall.controller.api;

import com.cafe24.shoppingmall.config.AppConfig;
import com.cafe24.shoppingmall.config.TestWebConfig;
import com.cafe24.shoppingmall.service.CartService;
import com.cafe24.shoppingmall.service.CategoryService;
import com.cafe24.shoppingmall.vo.CartVo;
import com.cafe24.shoppingmall.vo.CategoryVo;
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
public class CategoryControllerTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private CategoryService categoryService;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Ignore
    @Test
    public void testDICategoryService() {
        assertNotNull(categoryService);
    }

//    @Ignore
    @Test
    public void testAddCategory() throws Exception {

        // 200
        CategoryVo categoryVo = new CategoryVo();
        categoryVo.setName("상의");
//        categoryVo.setParentCategory();

        ResultActions resultActions = mockMvc
                .perform(post("/api/category")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new Gson().toJson(categoryVo)));

        resultActions.andExpect(status().isOk()).andDo(print()).
                andExpect(jsonPath("$.result", is("success")));
        // 200
         categoryVo = new CategoryVo();
        categoryVo.setName("반팔");
        categoryVo.setParentCategory(1);

         resultActions = mockMvc
                .perform(post("/api/category")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new Gson().toJson(categoryVo)));

        resultActions.andExpect(status().isOk()).andDo(print()).
                andExpect(jsonPath("$.result", is("success")));
    }

//    @Ignore
    @Test
    public void testAllCategory() throws Exception {

        // 200
        ResultActions resultActions = mockMvc
                .perform(get("/api/category").contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isOk()).andDo(print())
                .andExpect(jsonPath("$.result", is("success")));

    }

    @Test
    public void testGetCategoryByNo() throws Exception {

        // 200
        ResultActions resultActions = mockMvc
                .perform(get("/api/category/{no}",3).contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isOk()).andDo(print())
                .andExpect(jsonPath("$.result", is("success")));
        // 400
        resultActions = mockMvc
                .perform(get("/api/category/{no}",100).contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isBadRequest()).andDo(print())
                .andExpect(jsonPath("$.result", is("fail")));
//

    }

//    @Ignore
    @Test
    public void testDeleteCategory() throws Exception {

        // 200
        ResultActions resultActions = mockMvc
                .perform(delete("/api/category/{no}",8).contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isOk()).andDo(print())
                .andExpect(jsonPath("$.result", is("success")));

        // 400
        resultActions = mockMvc
                .perform(delete("/api/category/{no}",6).contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isBadRequest()).andDo(print())
                .andExpect(jsonPath("$.result", is("fail")));


    }
//    @Ignore
    @Test
    public void testUpdateCategory() throws Exception {


        // 200
        CategoryVo categoryVo=new CategoryVo();
        categoryVo.setName("선글라스");
        categoryVo.setCategoryNo(9);

        ResultActions resultActions = mockMvc
                .perform(put("/api/category")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new Gson().toJson(categoryVo)));
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
