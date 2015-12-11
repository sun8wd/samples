package com.celloud.dao;

import com.celloud.model.Student;

public interface StudentDao {

	public void insert(Student student);

	public Student getById(int id);
	
	public int removeAll();
}
