package com.tongdou.mvc.controller;

import com.tongdou.mvc.model.User;
import com.tongdou.mvc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * User controller
 * Created by shenyuzhu on 2017/11/19.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource(name = "userService")
    private UserService userService;

    public UserController() {
        logger.info("{} UserControllerConstructor", this);
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage() {
        return "user/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(User user) {

        ModelAndView modelAndView = new ModelAndView();

        if (userService.exist(user)) {
            modelAndView.setViewName("user/registerFail");
        } else {
            modelAndView.setViewName("user/userInfo");
        }

        modelAndView.addObject("user", user);
        return modelAndView;
    }
}
