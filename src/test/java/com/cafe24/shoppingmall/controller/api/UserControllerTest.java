package com.cafe24.shoppingmall.controller.api;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import com.cafe24.shoppingmall.config.AppConfig;
import com.cafe24.shoppingmall.config.WebConfig;
import com.cafe24.shoppingmall.service.UserService;
import com.cafe24.shoppingmall.vo.UserVo;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class, WebConfig.class})
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
	
	@Test
	public void testCheckId() throws Exception {
				ResultActions resultActions = mockMvc 
						.perform(get("/api/user/checkid/{id}", "user1").contentType(MediaType.APPLICATION_JSON));
				resultActions.andExpect(status().isOk()).andDo(print()).
				andExpect(jsonPath("$.result",is("success")))
				.andExpect(jsonPath("$.data",is("user1")));
	}
	
	@Test
	public void testJoin() throws Exception {
		UserVo userVo=new UserVo();
		userVo.setId("user2");
		userVo.setPassword("1234");
		userVo.setName("김가나");
		userVo.setPhone("010-9999-4444");
		userVo.setEmail("asd@naver.com");
		userVo.setBirth("920101");
		
		ResultActions resultActions = mockMvc 
				.perform(post("/api/user/join")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(userVo)));
					
		resultActions.andExpect(status().isOk()).andDo(print()).
		andExpect(jsonPath("$.result",is("success")));
	}
	
	@Test
	public void testLogin() throws Exception {
		UserVo userVo=new UserVo();
		userVo.setId("user2");
		userVo.setPassword("1234");
		ResultActions resultActions = mockMvc 
				.perform(post("/api/user/login")
						.contentType(MediaType.APPLICATION_JSON)
						.content(new Gson().toJson(userVo)));
		
		resultActions.andExpect(status().isOk()).andDo(print()).
		andExpect(jsonPath("$.result",is("success")));
	}
	

}
