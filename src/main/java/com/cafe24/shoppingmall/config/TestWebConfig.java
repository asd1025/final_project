package com.cafe24.shoppingmall.config;

import com.cafe24.config.web.MessageConfig;
import com.cafe24.config.web.SwaggerConfig;
import com.cafe24.config.web.TestMVCConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"com.cafe24.shoppingmall.controller", "com.cafe24.shoppingmall.exception"})
@Import({TestMVCConfig.class ,SwaggerConfig.class, MessageConfig.class})
public class TestWebConfig {
}
