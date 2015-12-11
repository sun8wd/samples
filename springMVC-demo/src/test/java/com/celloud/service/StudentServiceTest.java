package com.celloud.service;

import java.util.Random;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.celloud.model.Student;

@RunWith(SpringJUnit4ClassRunner.class) // 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:springMVC.xml" })
public class StudentServiceTest {
	@Resource
	private StudentService service;
	@Test
	public void test(){
		Student student  = new Student();
		student.setAge(new Random().nextInt(80)+20);
		student.setCode("200001");
		student.setName("玛丽");
		int id =  service.add(student);
		Student temp = service.getById(id);
		System.out.println("id="+id);
		System.out.println(temp.getAge()==student.getAge());
	}
	@Test
	public void testTx(){
		Student student  = new Student();
		student.setAge(new Random().nextInt(80)+20);
		student.setCode("200001");
		student.setName("玛丽");
		int id =  service.addException(student);
		//运行不到这里，上边会直接出异常，看一下数据库有没有都一条数据就知道事务是否成功
		System.out.println(id);
	}

}
