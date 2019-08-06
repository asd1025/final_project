package com.cafe24.shoppingmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	@RequestMapping( value={"/", "/main"} )

	@ResponseBody
	public String main() {
		return "index";
	}
	
}
