package com.springacademy.userservice.services;

import com.springacademy.userservice.Exception.ValidTokenNotFoundException;
import com.springacademy.userservice.models.Token;
import com.springacademy.userservice.models.User;
import org.springframework.stereotype.Service;


@Service
public interface UserService {
   Token login(String username, String password);

   User SignUp(String username,  String email,String password);

   void Logout(String token) throws ValidTokenNotFoundException;

   boolean validateToken(String token);


}
