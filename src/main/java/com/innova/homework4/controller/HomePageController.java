package com.innova.homework4.controller;

import com.innova.homework4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @Autowired
    private UserRepository userRepository;

    // Anasayfaya yönlendirilir.
    @GetMapping("/")
    public String viewHomePage(){
        return "index";
    }

    // Kayıt olan bütün kullanıcılar listelenir.
    @GetMapping("/all-users")
    public String viewAllUsers(Model model){
        model.addAttribute("key_users", this.userRepository.findAll());
        return "display_user";
    }
}
