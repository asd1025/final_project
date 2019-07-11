package com.cafe24.shoppingmall.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.cafe24.config.web.SwaggerConfig;
import com.cafe24.config.web.TestMVCConfig;

@Configuration
@EnableWebMvc
@ComponentScan({ "com.cafe24.shoppingmall.controller", "com.cafe24.shoppingmall.exception" })
@Import({ TestMVCConfig.class,SwaggerConfig.class })
public class TestWebConfig {
   
}