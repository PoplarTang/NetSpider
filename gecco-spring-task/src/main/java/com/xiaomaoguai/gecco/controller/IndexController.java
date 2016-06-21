package com.xiaomaoguai.gecco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("index")
public class IndexController {

	/**
	 * 首页
	 */
	@RequestMapping
	public String index() {
		return "index";
	}

}
