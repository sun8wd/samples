package com.celloud.action;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.celloud.model.Student;
import com.celloud.validator.StudentValidator;

@Controller
@RequestMapping("/paramValid")
public class ParamValidAction {
	@RequestMapping("toAdd")
	public ModelAndView toAdd(){
		ModelAndView mv = new ModelAndView("paramValid");
		return mv.addObject(new Student());
	}
	@RequestMapping("addStudent")
	public ModelAndView addStudent(@Validated Student student,BindingResult result){
		ModelAndView mv = new ModelAndView("paramValid");
		if(result.hasErrors()){
			//return other view
		}
		//。。。
		return mv;
	}
	@InitBinder
	public void bindValidtor(WebDataBinder binder){
		binder.addValidators(new StudentValidator());
	}
}
