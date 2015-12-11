package com.celloud.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.celloud.model.User;

public class UserUtils {
	private static Map<Integer,User> userMap;
	private static int nextId=1;
	static {
		String[] names = new String[] { "张三", "李四", "王五", "陈恩", "孙久", "赵琦", "钱施", "周莉", "吴晨", "郑实", "冯程程" };
		userMap = new HashMap<>();
		while(nextId<100){
			User user = new User();
			user.setId(nextId);
			user.setAddress("北京市朝阳区朝阳路住邦2000大厦");
			user.setName(names[new Random().nextInt(names.length)]);
			user.setHeight(new Random().nextInt(30) * 1.0 + 150.0);
			user.setAge(new Random().nextInt(10) + 20);
			user.setBirthday(new Date());
			user.setMarried(new Random().nextBoolean());
			user.setPhone("1861136" + (new Random().nextInt(8999) + 1000));
			userMap.put(nextId, user);
			nextId++;
		}
	}
	public List<User> findALlUsers(){
		List<User> users = new ArrayList<>();
		users.addAll(userMap.values());
		Collections.sort(users,new Comparator<User>() {
			@Override
			public int compare(User o1, User o2) {
				return o1.getId()-o2.getId();
			}
		});
		return users;
	}
	public int countUsers(){
		return userMap.size();
	}
	public List<User> pageUsers(int start,int offset){
		List<User> users = this.findALlUsers();
		return users.subList(start, start+offset);
	}
	public boolean add(User user){
		user.setId(nextId);
		userMap.put(user.getId(),user);
		nextId++;
		return true;
	}
	public User deleteById(int id){
		return userMap.remove(id);
	}
	public User update(User user){
		return userMap.put(user.getId(), user);
	}
}
