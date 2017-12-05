package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @discription
 * @author 作者 yepinjia
 * @version 创建时间：2017年8月28日 下午3:58:59
 * 
 */
@Controller
public class JspTestController {

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String from(Model model) {

		model.addAttribute("username", "tomcat");
		return "test";
	}
}
