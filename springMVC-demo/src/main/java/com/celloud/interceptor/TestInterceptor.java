package com.celloud.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.celloud.utils.PrintUtils;

public class TestInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	    PrintUtils.println("【Interceptor】 request preHandle:"+request.getRequestURI());
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	    PrintUtils.println("【Interceptor】 request postHandle:"+request.getRequestURI());
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	    PrintUtils.println("【Interceptor】 request afterCompletion:"+request.getRequestURI());
		super.afterCompletion(request, response, handler, ex);
	}
}
