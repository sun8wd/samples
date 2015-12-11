package com.celloud.service;

import com.celloud.model.Student;

public interface StudentService {
	
	public int add(Student student);
	
	public Student getById(int id);
	
	public int addException(Student student);

}
