package com.CardGameBlackJack.controller;

import com.CardGameBlackJack.dto.UserRequest;
import com.CardGameBlackJack.dto.UserUpdateRequest;
import com.CardGameBlackJack.model.User;
import com.CardGameBlackJack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/users")
//@RequiredArgsConstructor
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public User registerUser(@RequestBody UserRequest newUser) {
        return userService.createUser(newUser);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserRequest userRequest) {
        Optional<User> user = userService.findUser(userRequest.getUsername(), userRequest.getPassword());
        if (user.isPresent()) {
            return ResponseEntity.ok("User logged in successfully");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
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
}
