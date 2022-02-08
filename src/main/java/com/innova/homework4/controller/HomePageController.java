package com.innova.homework4.controller;

import com.innova.homework4.dto.UserEntityDto;
import com.innova.homework4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class HomePageController {

    @Autowired
    private UserRepository userRepository;

    // Anasayfaya yönlendirilir ve kayit olan butun kullanicilar getirilir.
    @GetMapping("/")
    public String viewHomePage(Model model){

        //Rest istegi.
        String URL="http://localhost:8081/rest/getAllUser";
        RestTemplate restTemplate=new RestTemplate();
        List<UserEntityDto> jsonListData=restTemplate.getForObject(URL,List.class);

        model.addAttribute("key_users", jsonListData);
        return "index";
    }
}
