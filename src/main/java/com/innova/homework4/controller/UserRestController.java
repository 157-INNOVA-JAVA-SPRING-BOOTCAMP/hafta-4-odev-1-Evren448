package com.innova.homework4.controller;

import com.innova.homework4.dto.UserEntityDto;
import com.innova.homework4.entity.UserEntity;
import com.innova.homework4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserRestController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/rest/getAllUser")
    public Iterable<UserEntityDto> getAllUser(){

        List<UserEntityDto> dtoList = new ArrayList<>();
        Iterable<UserEntity> userList = this.userRepository.findAll();

        for (UserEntity user: userList) {

            UserEntityDto dto = UserEntityDto.builder()
                    .name(user.getName())
                    .id(user.getId())
                    .email(user.getEmail())
                    .surname(user.getSurname())
                    .createdDate(user.getCreatedDate())
                    .build();

            dtoList.add(dto);
        }

        return dtoList;
    }
}
