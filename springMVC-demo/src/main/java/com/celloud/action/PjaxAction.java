package com.celloud.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
//TODO modelAndView modelMap model区别
@Controller
@RequestMapping("pjax")
public class PjaxAction {
	@RequestMapping("index")
	public String pjax(){
		return "pjax/index";
	}
	@RequestMapping("home")
	public String home(){
		return "pjax/default";
	}
	@RequestMapping("student/list")
	public String students(){
		return "pjax/studentList";
	}
	@RequestMapping("student/{id}")
	public ModelAndView student(@PathVariable int id){
		return new ModelAndView("pjax/student").addObject("id",id);
	}
	@RequestMapping("user/list")
	public String users(){
		return "pjax/userList";
	}
	@RequestMapping("user/{id}")
	public ModelAndView user(@PathVariable int id){
		return new ModelAndView("pjax/user").addObject("id",id);
	}
	@RequestMapping("teacher/list")
	public String teachers(){
		return "pjax/teacherList";
	}
	@RequestMapping("teacher/{id}")
	public ModelAndView teacher(@PathVariable int id){
		return new ModelAndView("pjax/teacher").addObject("id",id);
	}

}
