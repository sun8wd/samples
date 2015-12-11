package com.celloud.dao.impl;

import javax.annotation.Resource;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.springframework.stereotype.Service;

import com.celloud.dao.StudentDao;
import com.celloud.model.Student;

@Service("studentDaoInMorphia")
public class StudentDaoInMorphia implements StudentDao {
	@Resource
	private Datastore dataStore;

	@Override
	public void insert(Student student) {
		dataStore.save(student);
	}

	@Override
	public Student getById(int id) {
		return dataStore.createQuery(Student.class).field("id").equal(id).get();
	}

	@Override
	public int removeAll() {
		Query<Student> query = dataStore.createQuery(Student.class);
		return dataStore.delete(query).getN();
	}

}
