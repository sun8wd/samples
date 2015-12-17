package com.celloud.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.celloud.model.Student;

public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(Student.class);
	}
	//TODO 不用SpringMVC的标签，如何接收errors
	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code", "student.code.required", "编号不能为空！");
		Student student = (Student) target;
		if (student.getCode() != null) {
			if (student.getCode().length() != 6) {
				errors.rejectValue("code", "student.code.length", "编号长度必须为6！");
			}
			int code = -1;
			try {
				code = Integer.parseInt(student.getCode());
			} catch (Exception e) {
			}
			if (code == -1) {
				errors.rejectValue("code", "student.code.number", "编号不能包含非数字！");
			}
			if (code != -1 && student.getCode().startsWith("0")) {
				errors.rejectValue("code", "student.code.start", "编号不能以0开头！");
			}
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "student.name.required", "姓名不能为空！");
		if (student.getName() != null) {
			if (student.getName().length() > 8) {
				errors.rejectValue("name", "student.name.maxLength", "姓名长度不能超过8！");
			}
			if (student.getName().length() < 2) {
				errors.rejectValue("name", "student.name.minLength", "姓名长度不能小于2！");
			}
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", "student.age.required", "年龄不能为空");
		if (student.getAge() != null) {
			if (student.getAge() > 150) {
				errors.rejectValue("age", "student.age.maxAge", "年龄不能超过150岁！");
			}
			if (student.getAge() < 10) {
				errors.rejectValue("age", "student.age.minAge", "年龄不能小于10岁！");
			}
		}

	}

}
