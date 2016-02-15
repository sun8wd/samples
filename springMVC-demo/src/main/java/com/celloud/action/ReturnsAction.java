package com.celloud.action;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.celloud.model.Student;

/**
 * 
 * 
 * @author <a href="sunwendong@celloud.cn">sun8wd</a>
 * @date 2015年12月22日 下午1:44:29
 */
@Controller
@RequestMapping("returns")
public class ReturnsAction {
    @RequestMapping("index1")
    public String index1() {
        return "returns/index1";
    }

    @RequestMapping("index2")
    public Model index2(Model model) {
        model.addAttribute("name","lily");
        return model;
    }

    @RequestMapping("index3")
    public ModelAndView index3() {
        ModelAndView mv = new ModelAndView("index3");
        mv.addObject("name", "韩梅梅");
        return mv;
    }

    @RequestMapping("index4")
    public Map<String, Object> index4() {
        Map<String,Object> map = new HashMap<>();
        map.put("name", "李雷");
        return new HashMap<String, Object>();
    }

    @RequestMapping("index5")
    public Student index5() {
        Student stu = new Student();
        stu.setId(1);
        stu.setAge(18);
        stu.setBirthday(new Date());
        stu.setCode("100002");
        stu.setName("赵钱孙");
        return stu;
    }

    @RequestMapping("index6")
    @ResponseBody
    public Student index6() {
        Student stu = new Student();
        stu.setId(1);
        stu.setAge(18);
        stu.setBirthday(new Date());
        stu.setCode("100002");
        stu.setName("赵钱孙");
        return stu;
    }
}
