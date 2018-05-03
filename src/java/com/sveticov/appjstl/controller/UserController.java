package com.sveticov.appjstl.controller;

import com.sveticov.appjstl.model.UserModel;
import com.sveticov.appjstl.repository.UMRepository;
import com.sveticov.appjstl.repository.UserModelRepository;
import com.sveticov.appjstl.validator.UserValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import javax.validation.Valid;
import java.util.Date;
import java.util.Optional;

@Controller
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserValidator userValidator;
    @Autowired
    UMRepository repository;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(userValidator);
    }

    @GetMapping("/")
    public String messUser(Model model) {
        model.addAttribute("time", new Date());
        model.addAttribute("message", "Hello World");
        return "welcome";
    }

    @GetMapping("/user/model/{id}")
    public String getUser(@PathVariable("id") int id, Model model) {
        UserModel user = repository.findUserModelByID(id);
        logger.info(user.toString());
        model.addAttribute("user", user);
        return "user_page";
    }

    @GetMapping("/user/register")
    public String userRegister(Model model) {
        UserModel userModel = new UserModel();
        userModel.setCartons(null);
        model.addAttribute("title", "Add new user");
        model.addAttribute("user", userModel);
        return "user_register";
    }

    @PostMapping("/user/add")
    public String submit(@Validated @ModelAttribute(name = "user") UserModel userModel, BindingResult result,
                         Model model) {
        if (result.hasErrors()) {
            logger.error( result.toString());
            return "user_register";
        }
        userModel.setCartons(null);
        repository.saveUserModel(userModel);
        logger.error(userModel.toString());
        model.addAttribute("user", userModel);
        return "user_data";
    }

    @GetMapping("/foo")
    public String foo(Model model) {
        throw new RuntimeException("Foo");
    }


    @GetMapping("/login")
    public String login(){
        return "login";
    }




}
