package com.cafe24.shoppingmall.controller.api;

import com.cafe24.shoppingmall.config.AppConfig;
import com.cafe24.shoppingmall.config.TestWebConfig;
import com.cafe24.shoppingmall.service.UserService;
import com.cafe24.shoppingmall.vo.UserVo;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, TestWebConfig.class})
@WebAppConfiguration
public class UserControllerTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private UserService userService;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Ignore
    @Test
    public void testDIUserService() {
        assertNotNull(userService);
    }

    @Ignore
    @Test
    public void testCheckId() throws Exception {
        // 200 ok
        ResultActions resultActions = mockMvc
                .perform(get("/api/user/checkId/{id}", "user1").contentType(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isOk()).andDo(print()).
                andExpect(jsonPath("$.result", is("success")));

        // 400 id 중복
        resultActions = mockMvc
                .perform(get("/api/user/checkId/{id}", "test").contentType(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isBadRequest()).andDo(print())
                .andExpect(jsonPath("$.result", is("fail")));

        // 400 id invalid
        resultActions = mockMvc
                .perform(get("/api/user/checkId/{id}", "a###").contentType(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isBadRequest()).andDo(print())
                .andExpect(jsonPath("$.result", is("fail")));
    }

    @Ignore
    @Test
    public void testJoin() throws Exception {

        // 200
        UserVo userVo = new UserVo();
        userVo.setId("user2");
        userVo.setPassword("1234!!!a");
        userVo.setName("김가나");
        userVo.setPhone("010-9999-4444");
        userVo.setEmail("asd@naver.com");
        userVo.setBirth("920101");

        ResultActions resultActions = mockMvc
                .perform(post("/api/user/join")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new Gson().toJson(userVo)));

        resultActions.andExpect(status().isOk()).andDo(print()).
                andExpect(jsonPath("$.result", is("success")));

        // 400 join fail
          userVo = new UserVo();
        userVo.setId("user2");
        userVo.setPassword("1234!!!a");
        userVo.setName("김가나");
        userVo.setPhone("010-9999-4444");
        userVo.setEmail("asd@naver.com");
        userVo.setBirth("920101");

          resultActions = mockMvc
                .perform(post("/api/user/join")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new Gson().toJson(userVo)));

        resultActions.andExpect(status().isBadRequest()).andDo(print()).
                andExpect(jsonPath("$.result", is("fail")));

        // 400 id invalid
        userVo = new UserVo();
        userVo.setId("us");
        userVo.setPassword("1234!!!a");
        userVo.setName("김가나");
        userVo.setPhone("010-9999-4444");
        userVo.setEmail("asd@naver.com");
        userVo.setBirth("920101");

        resultActions= mockMvc
                .perform(post("/api/user/join")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new Gson().toJson(userVo)));

        resultActions.andExpect(status().isBadRequest()).andDo(print()).
                andExpect(jsonPath("$.result", is("fail")));

        // 400 email invalid
        userVo = new UserVo();
        userVo.setId("user2");
        userVo.setPassword("1234!!!a");
        userVo.setName("김가나");
        userVo.setPhone("010-9999-4444");
        userVo.setEmail("asd .com");
        userVo.setBirth("920101");

        resultActions= mockMvc
                .perform(post("/api/user/join")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new Gson().toJson(userVo)));
        resultActions.andExpect(status().isBadRequest()).andDo(print()).
                andExpect(jsonPath("$.result", is("fail")));

        // 400 password invalid
        userVo = new UserVo();
        userVo.setId("user2");
        userVo.setPassword("1234");
        userVo.setName("김가나");
        userVo.setPhone("010-9999-4444");
        userVo.setEmail("asd@naver.com");
        userVo.setBirth("920101");

        resultActions = mockMvc
                .perform(post("/api/user/join")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new Gson().toJson(userVo)));
        resultActions.andExpect(status().isBadRequest()).andDo(print()).
                andExpect(jsonPath("$.result", is("fail")));

        //400 phone invalid
        userVo = new UserVo();
        userVo.setId("user2");
        userVo.setPassword("1234");
        userVo.setName("김가나");
        userVo.setPhone("010-aaaa-4444");
        userVo.setEmail("asd@naver.com");
        userVo.setBirth("920101");

        resultActions = mockMvc
                .perform(post("/api/user/join")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new Gson().toJson(userVo)));
        resultActions.andExpect(status().isBadRequest()).andDo(print()).
                andExpect(jsonPath("$.result", is("fail")));



    }

    @Ignore
    @Test
    public void testLogin() throws Exception {

        // 200 로그인 성공
        UserVo userVo = new UserVo();
        userVo.setId("user2");
        userVo.setPassword("123456!a");

        ResultActions resultActions = mockMvc
                .perform(post("/api/user/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new Gson().toJson(userVo)));

        resultActions.andExpect(status().isOk()).andDo(print()).
                andExpect(jsonPath("$.result", is("success")));

        // 400 로그인 정보 없음
        userVo = new UserVo();
        userVo.setId("user2");
        userVo.setPassword("1234");

        resultActions = mockMvc
                .perform(post("/api/user/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new Gson().toJson(userVo)));

        resultActions.andExpect(status().isBadRequest()).andDo(print())
                .andExpect(jsonPath("$.result", is("fail")));
    }


}
