package com.CardGameWar.controller;

import com.CardGameWar.dto.UserRequest;
import com.CardGameWar.dto.UserUpdateRequest;
import com.CardGameWar.exception.UserNotFoundException;
import com.CardGameWar.model.User;
import com.CardGameWar.repository.UserRepository;
import com.CardGameWar.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.message.StringFormattedMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
//@RequiredArgsConstructor
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User registerUser(@RequestBody UserRequest newUser) {
        return userService.createUser(newUser);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public String changeUser(@RequestBody UserUpdateRequest userToUpdate) {
        userService.updateUser(userToUpdate);
        return String.format("User with id '%d' updated successfully!", userToUpdate.getId());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<User> getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping
    List<User> getAllUsers() {
        return userService.getUsers();
    }

    @DeleteMapping("/{id}")
    String deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return "User has been deleted successfully!";
    }

    @DeleteMapping
    public String deleteAllUsers() {
        if (userService.getUsers().isEmpty()) {
            return "No users to delete!";
        }
        userService.deleteUsers();
        return "All users have been successfully deleted!";
    }
}
