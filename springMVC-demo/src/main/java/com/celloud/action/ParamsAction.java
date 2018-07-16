package com.celloud.action;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.celloud.model.Student;
import com.celloud.model.User;

@Controller
@RequestMapping("/params")
public class ParamsAction {
	@RequestMapping("/date")
	public ModelAndView index(Date date) {
		System.out.println(date);
		ModelAndView mv = new ModelAndView("params");
		mv.addObject("params", date);
		return mv;
	}

	/**
	 * 基本类型参数传递
	 * 
	 * @param num
	 * @return
	 */
	@RequestMapping("/int")
	public ModelAndView index(int num) {
		ModelAndView mv = new ModelAndView("params");
		mv.addObject("params", num);
		return mv;
	}

	// TODO 需要验证
	@RequestMapping("/list/string")
	public ModelAndView index(@RequestParam List<String> lists) {
		ModelAndView mv = new ModelAndView("params");
		String params = "list:";
		if (lists != null) {
			for (String str : lists) {
				params += str + ",";
			}
		}
		mv.addObject("params", params);
		return mv;
	}

	// TODO 需要验证
	@RequestMapping("/list/student")
	public ModelAndView index1(@RequestParam("lists[]") List<Student> lists) {
		ModelAndView mv = new ModelAndView("params");
		String params = "list:";
		if (lists != null) {
			for (Student student : lists) {
				params += student.getCode() + "," + student.getName() + ";";
			}
		}
		mv.addObject("params", params);
		return mv;
	}

	/**
	 * 包装类型参数传递
	 * 
	 * @param num
	 * @return
	 */
	@RequestMapping("/integer")
	public ModelAndView index(Integer num) {
		ModelAndView mv = new ModelAndView("params");
		mv.addObject("params", num);
		return mv;
	}

	/**
	 * 自定义类型参数传递
	 * 
	 * @param student
	 * @return
	 */
	@RequestMapping("/student")
	public ModelAndView index(Student student) {
		ModelAndView mv = new ModelAndView("params");
		String params = "student:";
		params += "code=" + student.getCode() + ",";
		params += "name=" + student.getName();
		mv.addObject("params", params);
		return mv;
	}

	/**
	 * 复合类型参数传递
	 * 
	 * @param objectForm
	 * @return
	 */
	@RequestMapping("/object")
	public ModelAndView index(ObjectForm objectForm) {
		ModelAndView mv = new ModelAndView("params");
		String params = "";
		params += "student.code=" + objectForm.getStudent().getCode() + ",";
		params += "student.name=" + objectForm.getStudent().getName() + ";";
		params += "user.name=" + objectForm.getUser().getName() + ",";
		params += "user.phone=" + objectForm.getUser().getPhone() + ";";
		mv.addObject("params", params);
		return mv;
	}

	/**
	 * 数组类型参数传递
	 * 
	 * @param arrayForm
	 * @return
	 */
	@RequestMapping("/array")
	public ModelAndView index(ArrayForm arrayForm) {
		ModelAndView mv = new ModelAndView("params");
		String params = "array:";
		if (arrayForm != null && arrayForm.getArray() != null) {
			for (String str : arrayForm.getArray()) {
				params += str + ",";
			}
		}
		mv.addObject("params", params);
		return mv;
	}

	/**
	 * list参数传递
	 * 
	 * @param listForm
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView index(ListForm listForm) {
		ModelAndView mv = new ModelAndView("params");
		String params = "list:";
		if (listForm != null && listForm.getList() != null) {
			for (String str : listForm.getList()) {
				params += str + ",";
			}
		}
		mv.addObject("params", params);
		return mv;
	}

	/**
	 * List+自定义类型参数传递
	 * 
	 * @param listStudentForm
	 * @return
	 */
	@RequestMapping("/listStudent")
	public ModelAndView index(ListStudentForm listStudentForm) {
		ModelAndView mv = new ModelAndView("params");
		String params = "list:";
		if (listStudentForm != null && listStudentForm.getList() != null) {
			for (Student student : listStudentForm.getList()) {
				params += student.getCode() + "," + student.getName() + ";";
			}
		}
		mv.addObject("params", params);
		return mv;
	}

	/**
	 * set类型参数传递
	 * 
	 * @param setForm
	 * @return
	 */
	@RequestMapping("/set")
	public ModelAndView index(SetForm setForm) {
		ModelAndView mv = new ModelAndView("params");
		String params = "set:";
		if (setForm != null && setForm.getSet() != null) {
			for (String str : setForm.getSet()) {
				params += str + ",";
			}
		}
		mv.addObject("params", params);
		return mv;
	}

	/**
	 * map类型参数传递
	 * 
	 * @param MapForm
	 * @return
	 */
	@RequestMapping("/map")
	public ModelAndView index(MapForm MapForm) {
		ModelAndView mv = new ModelAndView("params");
		String params = "map:";
		if (MapForm != null && MapForm.getMap() != null) {
			for (Map.Entry<String, String> entry : MapForm.getMap().entrySet()) {
				params += entry.getKey() + "--" + entry.getValue() + ";";
			}
		}
		mv.addObject("params", params);
		return mv;
	}

}

class ObjectForm {
	private User user;
	private Student student;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}

class ArrayForm {
	private String[] array;

	public String[] getArray() {
		return array;
	}

	public void setArray(String[] array) {
		this.array = array;
	}

}

class ListForm {
	private List<String> list;

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

}

class ListStudentForm {
	private List<Student> list;

	public List<Student> getList() {
		return list;
	}

	public void setList(List<Student> list) {
		this.list = list;
	}

}

class SetForm {
	private Set<String> set;

	public Set<String> getSet() {
		return set;
	}

	public void setSet(Set<String> set) {
		this.set = set;
	}

}

class MapForm {
	private Map<String, String> map;

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

}