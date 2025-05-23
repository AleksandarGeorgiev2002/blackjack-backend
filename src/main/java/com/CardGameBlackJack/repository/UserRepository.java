package com.CardGameBlackJack.repository;

import com.CardGameBlackJack.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByUsername(String username);

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

    Optional<User> findUserByUsernameAndPassword(String username, String password);
}
