package com.celloud.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * SpringMVC的action类示例，测试SpringMVC框架搭建是否成功
 * @author <a href="mailto:sunwendong@celloud.cn">sun8wd</a>
 * @date 2015年12月3日下午3:52:01
 * @version Revision: 1.0
 */
@Controller
@RequestMapping("/demo")
public class DemoAction {
	@RequestMapping("list")
	public ModelAndView index(String name){
		ModelAndView mv = new ModelAndView("demo");
		name=name==null?"world":name;
		System.out.println("name="+name);
		mv.addObject("name", name);
		return mv;
	}
}
