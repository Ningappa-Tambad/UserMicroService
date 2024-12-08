package com.springacademy.userservice.repositories;

import com.springacademy.userservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Savepoint;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {


  User save(User user); //Upsert--updte+insert

  @Override
  Optional<User> findById(Long aLong);

  Optional<User> findByEmail(String email);
}
