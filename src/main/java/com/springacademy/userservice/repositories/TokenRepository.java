package com.springacademy.userservice.repositories;

import com.springacademy.userservice.models.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;


@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {


   Token save(Token token);


   //Selet * from tokens where value = ? and expiry_date > current_date and is_active = false

   Optional<Token> findByValueAndExpiryAtAndDeleted(String value, Date expiryAt, boolean deleted);
}
