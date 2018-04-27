package com.sveticov.appjstl.controller;

import com.sveticov.appjstl.model.UserModel;
import com.sveticov.appjstl.repository.CartonsRepositoryImpl;
import com.sveticov.appjstl.repository.UMRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserModelController {

    private Logger logger = LoggerFactory.getLogger(UserModelController.class);

    @Autowired
    UMRepository repository;
    @Autowired
    CartonsRepositoryImpl cartonsRepository;

    @GetMapping("/user/id")
    public String userByIDGET(Model model) {
        model.addAttribute("text", "User by ID");
        return "user_find_id";
    }

    @PostMapping("/user/id")
    public String userByID(@RequestParam int id_user_model,Model model) {
        logger.info(String.valueOf(id_user_model));
     UserModel userModel= repository.findUserModelByID(id_user_model);
     model.addAttribute("user",userModel);

        return "user_page";
    }
}
