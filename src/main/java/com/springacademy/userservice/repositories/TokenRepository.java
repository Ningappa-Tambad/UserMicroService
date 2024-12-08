package com.springacademy.userservice.repositories;

import com.springacademy.userservice.models.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, Long> {


   Token save(Token token);
}
