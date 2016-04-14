package com.celloud.action;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.celloud.model.Resource;
import com.celloud.model.User;
import com.celloud.service.ResourceService;
import com.celloud.service.UserService;

@Controller
public class HomeAction {
    @javax.annotation.Resource
    private UserService userService;
    @javax.annotation.Resource
    private ResourceService resourceService;

    @RequestMapping("index")
    public ModelAndView index() {
        List<Resource> resources = resourceService.findAllResources();
        System.out.println(SecurityUtils.getSubject().getPrincipal());
        return new ModelAndView("index").addObject("resources", resources);
    }

    @RequestMapping("logout")
    public ModelAndView logout() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            subject.logout();
        }
        return new ModelAndView("redirect:login");
    }

    @RequestMapping("login")
    public ModelAndView login() {
        return new ModelAndView("login").addObject("user", new User());
    }

    @RequestMapping(path = "login", method = RequestMethod.POST)
    public String doLogin(User user, boolean rememberMe, Model model) {
        System.out.println("username=" + user.getUsername());
        System.out.println("password=" + user.getPassword());
        System.out.println("remember=" + rememberMe);
        // user = userService.login(user.getUsername(), user.getPassword());
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            subject.logout();
        }
        String msg = "";
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        token.setRememberMe(rememberMe);
        try {
            subject.login(token);
        } catch (IncorrectCredentialsException | UnknownAccountException e) {
            msg = "用户不存在或密码错误.";
            model.addAttribute("message", msg).addAttribute("rememberMe", rememberMe);
            System.out.println(msg);
        }
        if (subject.isAuthenticated()) {
            return "redirect:/chat/index";
        } else {
            return "/login";
        }
    }
}
