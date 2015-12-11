package com.celloud.model;

import java.util.Date;

/**
 * 用户实体类-测试
 * 
 * @author <a href="mailto:sunwendong@celloud.cn">sun8wd</a>
 * @date 2015年12月4日上午10:02:38
 * @version Revision: 1.0
 */
public class User {
	/**
	 * 用户编号
	 */
	private int id;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 生日
	 */
	private Date birthday;
	/**
	 * 电话
	 */
	private String phone;
	/**
	 * 年龄
	 */
	private int age;
	/**
	 * 身高（cm）
	 */
	private double height;
	/**
	 * 是否已婚
	 */
	private boolean married;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public boolean isMarried() {
		return married;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}

}
