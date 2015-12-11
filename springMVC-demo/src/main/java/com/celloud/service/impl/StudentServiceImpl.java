package com.celloud.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.celloud.mapper.StudentMapper;
import com.celloud.model.Student;
import com.celloud.service.StudentService;

@Service("student")
public class StudentServiceImpl implements StudentService {
	@Resource
	private StudentMapper mapper;

	@Override
	public int add(Student student) {
		mapper.insertSelective(student);
		return student.getId();
	}

	@Override
	public Student getById(int id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int addException(Student student) {
		mapper.insertSelective(student);
		Integer.parseInt("a");
		return student.getId();
	}
}
