package com.celloud.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.celloud.model.Student;
import com.celloud.model.User;
import com.celloud.service.StudentService;
import com.celloud.service.UserService;

/**
 * 
 * @author <a href="mailto:sunwendong@celloud.cn">sun8wd</a>
 * @date 2015年12月4日上午10:15:35
 * @version Revision: 1.0
 */
@Controller
@RequestMapping("/user")
public class UserAction {
	@Resource
	private StudentService studentService;
	@Resource
	private UserService userService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	private ModelAndView index() {
		ModelAndView mv = new ModelAndView("users");
		List<User> users = userService.findAll();
		mv.addObject("users", users);
		studentService.getById(0);
		return mv;
	}

	@RequestMapping(value = {"page/{page}"}, method = RequestMethod.GET)
	private ModelAndView index(@PathVariable int page) {
		ModelAndView mv = new ModelAndView("users");
		List<User> users = userService.pageUsers((page-1)*10, 10);
		mv.addObject("users", users);
		int totals = userService.countUsers();
		mv.addObject("totals", totals);
		mv.addObject("totalPage", totals/10==0?totals/10:totals/10+1);
		return mv;
	}
	@RequestMapping(value = {"addUser"}, method = RequestMethod.GET)
	private ModelAndView addUser(@ModelAttribute("user") User user,@ModelAttribute("student") Student student){
		System.out.println(user.getName());
		System.out.println(student.getName());
		return index(1);
	}
	@InitBinder("user")
	public void bindUser(WebDataBinder binder){
		binder.setFieldDefaultPrefix("user.");
	}
	@InitBinder("student")
	public void bindStudent(WebDataBinder binder){
		binder.setFieldDefaultPrefix("student.");
	}
}
