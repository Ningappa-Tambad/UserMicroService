package com.springacademy.userservice.services;

import com.springacademy.userservice.models.Token;
import com.springacademy.userservice.models.User;
import com.springacademy.userservice.repositories.TokenRepository;
import com.springacademy.userservice.repositories.UserRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;


@Service
public class UserServiceImpl implements  UserService{


    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;
    private TokenRepository tokenRepository;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, TokenRepository tokenRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenRepository = tokenRepository;
    }




    @Override
    public Token login(String username, String password) {
           /*
        1.Find the user by email
        2.If the user is not present in the DB-Return an error message
        2. If user is present in the DB-Check if the password is correct
        3. If the password is correct-Generate a JWT token and return it
        4. If the password is incorrect-Return an error message
         */

        Optional<User> optionalUser= userRepository.findByEmail(username);

        if(optionalUser.isEmpty())
        {
            return null;
        }

        User user=optionalUser.get();

        com.springacademy.userservice.models.Token token=null;

        if(passwordEncoder.matches(password,user.getPassword()))
        {
           //Login successful

            token=new com.springacademy.userservice.models.Token();


             token.setUser(user);

            //Expiry time should be 30 days from now

            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE,30);
            Date date30daysfromnow=calendar.getTime();
            token.setExpiryAt(date30daysfromnow);

            //Token value can be any random string of 128 characters

            token.setValue(RandomStringUtils.randomAlphanumeric(128));

        }
        return tokenRepository.save(token);



    }

    @Override
    public User SignUp(String name, String email, String password) {


       Optional<User> optionalUser= userRepository.findByEmail(email);

       if(optionalUser.isPresent())
       {
           optionalUser.get();
       }

              User user = new User();
              user.setName(name);
              user.setEmail(email);

              user.setPassword(passwordEncoder.encode(password));
              user.setVerified(true);

           return userRepository.save(user);
    }

    @Override
    public void Logout(String token) {

    }

    @Override
    public boolean validateToken(String token) {
        return false;
    }
}
