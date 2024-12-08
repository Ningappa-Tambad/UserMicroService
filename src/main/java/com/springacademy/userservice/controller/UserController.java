package com.springacademy.userservice.controller;


import com.springacademy.userservice.dtos.LoginRequestDto;
import com.springacademy.userservice.dtos.SignUpRequestDto;
import com.springacademy.userservice.dtos.TokenDto;
import com.springacademy.userservice.dtos.UserDto;
import com.springacademy.userservice.models.Token;
import com.springacademy.userservice.models.User;
import com.springacademy.userservice.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController
{

    private UserService userService;

    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @PostMapping("/login")
    public TokenDto Login(@RequestBody LoginRequestDto requestDto)
    {

   Token token= userService.login(requestDto.getEmail(),requestDto.getPassword()
        );

   //Convert token to TokenDto


        return TokenDto.fromToken(token);

    }

    @PostMapping("/signup")
    public UserDto signUp(@RequestBody SignUpRequestDto signUpRequestDto)
    {

        User user=userService.SignUp(
                 signUpRequestDto.getName()
                ,signUpRequestDto.getEmail(),
                 signUpRequestDto.getPassword());
        return UserDto.from(user);
    }

    @GetMapping("/logout")
    public ResponseEntity<Void> Logout(LoginRequestDto loginRequestDto)
    {
        return null;
    }


    @GetMapping("/validateToken")
    public void validateToken(String token)
    {

    }
}
