package com.celloud.demos.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
@Component
public class GlobalExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@Bean
	public MethodValidationPostProcessor methodValidationPostProcessor() {
		return new MethodValidationPostProcessor();
	}

	@ExceptionHandler
	public ResponseEntity<Map<String, String>> exceptionHandler(RuntimeException e, HttpServletRequest request,
			HttpServletResponse response) {
		logger.error("系统出现未捕获的异常：{} {}", request.getMethod(), request.getRequestURI(), e);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new HashMap<String, String>() {
			private static final long serialVersionUID = 1L;

			{
				put("error", "系统出现未捕获的异常！");
			}
		});
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Map<String, String>> validationExceptionHandler(ConstraintViolationException e,
			HttpServletRequest request, HttpServletResponse response) {
		logger.error("系统出现参数校验异常：{} {}", request.getMethod(), request.getRequestURI(), e);
		logger.info(e.getConstraintViolations().toString());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new HashMap<String, String>() {
			private static final long serialVersionUID = 1L;

			{
				put("error", e.getLocalizedMessage());
			}
		});
	}

	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseEntity<Map<String, String>> missingParameterException(MissingServletRequestParameterException e,
			HttpServletRequest request, HttpServletResponse response) {
		logger.error("请求参数不存在：{} {} ,param={}", request.getMethod(), request.getRequestURI(), e.getParameterName(), e);
		return ResponseEntity.badRequest().body(new HashMap<String, String>() {
			private static final long serialVersionUID = 1L;

			{
				put(e.getParameterName(), "missing");
			}
		});
	}

	@ExceptionHandler(MissingParamException.class)
	public ResponseEntity<Map<String, String>> missingParamException(MissingParamException e,
			HttpServletRequest request, HttpServletResponse response) {
		logger.error("请求参数不存在：{} {} ,param={}", request.getMethod(), request.getRequestURI(), e.getParameterName(), e);
		return ResponseEntity.badRequest().body(new HashMap<String, String>() {
			private static final long serialVersionUID = 1L;

			{
				put(e.getParameterName(), "missing");
			}
		});
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<Map<String, String>> argumentTypeHandler(MethodArgumentTypeMismatchException e,
			HttpServletRequest request, HttpServletResponse response) {
		logger.error("请求参数的类型不合法：{} {} ,param={}", request.getMethod(), request.getRequestURI(), e.getName(), e);
		return ResponseEntity.badRequest().body(new HashMap<String, String>() {
			private static final long serialVersionUID = 1L;
			{
				put(e.getName(), "mismatch");
			}
		});
	}

	@ExceptionHandler(ValidationFailException.class)
	public ResponseEntity<List<FieldError>> validationFailExceptionHandler(ValidationFailException e,
			HttpServletRequest request, HttpServletResponse response) {
		logger.error("参数校验失败：{} {} ", request.getMethod(), request.getRequestURI());
		List<FieldError> result = new ArrayList<>();
		e.getErrors().getFieldErrors().forEach(f -> {
			logger.info("field={}, code={}, message={}", f.getField(), f.getCode(), f.getDefaultMessage());
			result.add(new FieldError(f.getField(), f.getCode(), f.getDefaultMessage()));
		});
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
	}

	@ExceptionHandler(ObjectAlreadyExistsException.class)
	public ResponseEntity<Map<String, String>> objectAlreadyExists(ObjectAlreadyExistsException e,
			HttpServletRequest request) {
		logger.error("数据已经存在异常:" + e.getParam());
		return ResponseEntity.badRequest().body(new HashMap<String, String>() {
			private static final long serialVersionUID = 1L;
			{
				put(e.getParam(), "exists");
			}
		});
	}

	@ExceptionHandler(UnauthorizedException.class)
	public ResponseEntity<Map<String, String>> requestUnauthorizedHandler(UnauthorizedException e,
			HttpServletRequest request, HttpServletResponse response) {
		logger.error("请求未授权：{} {} ", request.getMethod(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new HashMap<String, String>() {
			private static final long serialVersionUID = 1L;
			{
				put("error", "请求未授权!");
			}
		});
	}

	@ExceptionHandler(ForbiddenException.class)
	public ResponseEntity<Map<String, String>> requestForbiddenHandler(ForbiddenException e, HttpServletRequest request,
			HttpServletResponse response) {
		logger.error("{}：{} {} ", e.getMessage(), request.getMethod(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new HashMap<String, String>() {
			private static final long serialVersionUID = 1L;
			{
				put("error", e.getMessage());
			}
		});
	}

	class FieldError {
		private String field;
		private String code;
		private String message;

		public FieldError() {
		}

		public FieldError(String field, String code, String message) {
			super();
			this.field = field;
			this.code = code;
			this.message = message;
		}

		public String getField() {
			return field;
		}

		public void setField(String field) {
			this.field = field;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

	}
}
