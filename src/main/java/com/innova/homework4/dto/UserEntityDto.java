package com.innova.homework4.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntityDto {

    private Long id;

    @NotEmpty(message = "name can not be empty.")
    @NotNull(message = "name can not be null.")
    private String name;

    @NotEmpty(message = "surname can not be empty.")
    @NotNull(message = "surname can not be empty.")
    private String surname;

    @NotEmpty(message = "email can not be empty.")
    @NotNull(message = "email can not be empty.")
    @Email(message = "email has to an email pattern")
    private String email;
}
