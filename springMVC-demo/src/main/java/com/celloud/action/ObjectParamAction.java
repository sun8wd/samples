package com.celloud.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.celloud.model.Student;
import com.celloud.model.User;

@Controller
@RequestMapping("/objectParam")
public class ObjectParamAction {

	// private ModelAndView index(@ModelAttribute("user") User
	// user,@ModelAttribute("student") Student student){
	// ModelAndView mv = new ModelAndView("params");
	// System.out.println(user.getName());
	// System.out.println(student.getName());
	// return mv;
	// }
	@RequestMapping("/object")
	private ModelAndView index(@ModelAttribute User user, @ModelAttribute Student student) {
		ModelAndView mv = new ModelAndView("params");
		String params = "";
		params += "student.code=" + student.getCode() + ",";
		params += "student.name=" + student.getName() + ";";
		params += "user.name=" + user.getName() + ",";
		params += "user.phone=" + user.getPhone() + ";";
		mv.addObject("params", params);
		return mv;
	}

	@InitBinder("user")
	public void bindUser(WebDataBinder binder) {
		binder.setFieldDefaultPrefix("user.");
	}

	@InitBinder("student")
	public void bindStudent(WebDataBinder binder) {
		binder.setFieldDefaultPrefix("student.");
	}
}
