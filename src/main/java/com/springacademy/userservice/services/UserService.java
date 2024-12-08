package com.springacademy.userservice.services;

import com.springacademy.userservice.models.Token;
import com.springacademy.userservice.models.User;

public interface UserService {
   Token login(String username, String password);

   User SignUp(String username,  String email,String password);

   void Logout(String token);

   boolean validateToken(String token);


}
