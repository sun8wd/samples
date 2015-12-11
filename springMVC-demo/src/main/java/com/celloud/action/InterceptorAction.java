package com.celloud.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("interceptor")
public class InterceptorAction {
	@RequestMapping("index")
	public ModelAndView index(){
		System.out.println("【InterceptorAction】 执行action。。。");
		return new ModelAndView("interceptor");
	}
}
