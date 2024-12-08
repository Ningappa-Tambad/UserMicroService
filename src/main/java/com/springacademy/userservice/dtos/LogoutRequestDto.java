package com.springacademy.userservice.dtos;


import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.Token;

@Getter
@Setter
public class LogoutRequestDto {


    private Token token;
}
