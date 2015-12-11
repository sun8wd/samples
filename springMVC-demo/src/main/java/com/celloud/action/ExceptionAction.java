package com.celloud.action;

import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.celloud.exception.BusinessException;
import com.celloud.service.BusinessExceptionService;

@Controller
@RequestMapping("exception")
public class ExceptionAction {
	@Resource
	private BusinessExceptionService service;
	@RequestMapping("business")
	public ModelAndView business(){
		throw new BusinessException("异常测试-------");
		
	}
	@RequestMapping("error")
	public ModelAndView error(){
		if(new Random().nextBoolean()){
			throw new NullPointerException("我是action层的空指针。。。。。");
		}
		service.exception();
		return new ModelAndView("exception").addObject("msg","没有异常！");
	}
}
