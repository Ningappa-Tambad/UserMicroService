package com.springacademy.userservice.dtos;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class LogoutRequestDto {


    private String tokenValue;
}
