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
    public String userByID(@RequestParam int id_user_model, Model model) {


        logger.error(String.valueOf(id_user_model));
        UserModel userModel = repository.findUserModelByID(id_user_model);
        model.addAttribute("user", userModel);

        return "user_page";
    }
    @GetMapping("/us/cart/model1")
    public String modelUserAndCartonGet(Model model){

        model.addAttribute("title","user inner join cartons");
        return "model_user_carton_join";
    }

    @PostMapping("/us/cart/model")
    private String modelUserAndCarton(@RequestParam int id_us_cart, Model model) {

        UserModel userModel = null;

        userModel = repository.joinByIDUserModel(id_us_cart);//todo repository join
        logger.error(userModel.toString());
        model.addAttribute("titleUsCart", "Model User & Cartons");
        if (userModel.getId_user_model() != 0)
            model.addAttribute("modelUserAndCartons", userModel);
        if (userModel.getId_user_model() == 0)
            model.addAttribute("modelUserAndCartons", "Not found model (method inner)");
        return "model_user_cartons";
    }

    @GetMapping("/logout")
    public String logout(){
        return "welcome";
    }
}
