package com.innova.homework4.controller;

import com.innova.homework4.dto.UserEntityDto;
import com.innova.homework4.entity.UserEntity;
import com.innova.homework4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    private UserRepository userRepository;

    // Singup formuna yönlendirilir.
    @GetMapping("/sign-up")
    public String signUp(Model model){
        model.addAttribute("key_form",new UserEntityDto());
        return "signup_form";
    }

    // Validasyon kurallarından geçer ise veritabanına kayıt işlemi gerçekleşir.
    @PostMapping("/sign-up")
    public String signUp(@Valid @ModelAttribute("key_form") UserEntityDto dto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "signup_form";
        }

        UserEntity user = UserEntity.builder()
                .email(dto.getEmail())
                .name(dto.getName())
                .surname(dto.getSurname())
                .id(dto.getId())
                .build();

        this.userRepository.save(user);
        return "redirect:/all-users";
    }
}
