package com.steelgt.gavin.Controller;

import java.io.File;
import java.util.HashMap;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

	/**
	 * 本地访问内容地址 ：http://localhost:8080/hello
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/hello")
	public String helloHtml(HashMap<String, Object> map, Model model) {
		model.addAttribute("say", "欢迎欢迎,热烈欢迎");
		map.put("hello", "欢迎进入HTML页面");
		return "index";
	}

	@RequestMapping("/picUpload")
	public String picUpload() {
		return "picUpload";
	}

}
