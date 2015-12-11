package com.celloud.dao.impl;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.celloud.dao.StudentDao;
import com.celloud.model.Student;

//@Service("studentDaoInSpringData")
public class StudentDaoInSpringData implements StudentDao {
	@Resource
	private MongoTemplate mongoTemplate;

	@Override
	public void insert(Student student) {
		mongoTemplate.save(student);
	}

	@Override
	public Student getById(int id) {
		return mongoTemplate.findOne(new Query(Criteria.where("id").is(id)), Student.class);
	}

	@Override
	public int removeAll() {
		return mongoTemplate.findAllAndRemove(new Query(), Student.class).size();
	}

}
