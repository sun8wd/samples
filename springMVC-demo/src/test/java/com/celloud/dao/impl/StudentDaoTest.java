package com.celloud.dao.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.celloud.dao.StudentDao;
import com.celloud.model.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:springMVC.xml" })
public class StudentDaoTest {
	@Resource
	private StudentDao studentDao;
	@Test
	public void test() {
		System.out.println(studentDao.removeAll());
		Student stu = new Student();
		stu.setAge(19);
		stu.setBirthday(new Date());
		stu.setCode("1001");
		stu.setId(1);
		stu.setName("张三");
		studentDao.insert(stu);
		Student stu2 = studentDao.getById(1);
		System.out.println(stu2.getCode().equals(stu.getCode()));
	}

}
