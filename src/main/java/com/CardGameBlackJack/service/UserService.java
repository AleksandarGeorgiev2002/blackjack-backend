package com.CardGameBlackJack.service;

import com.CardGameBlackJack.dto.UserRequest;
import com.CardGameBlackJack.dto.UserUpdateRequest;
import com.CardGameBlackJack.exception.UserAlreadyExistsException;
import com.CardGameBlackJack.exception.UserNotFoundException;
import com.CardGameBlackJack.model.User;
import com.CardGameBlackJack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(UserRequest userRequest) {
        User user = new User();
        if (userRepository.existsByUsername(userRequest.getUsername())) {
            throw new UserAlreadyExistsException(userRequest.getUsername());
        }
        user.setUsername(userRequest.getUsername());
        user.setEmail(userRequest.getEmail());

        user.setPassword(userRequest.getPassword());
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long id) {
        if (userRepository.findById(id).isEmpty()){
            throw new UserNotFoundException(id);
        }
        return userRepository.findById(id);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void deleteUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            userRepository.delete(user);
        } else {
            throw new IllegalArgumentException(String.format("User with id '%s' doesn't exist", id.toString()));
        }
    }

    public void deleteUsers() {
        userRepository.deleteAll();
    }

    public User updateUser(UserUpdateRequest userToUpdate) {
        return userRepository.findById(userToUpdate.getId())
                .map(user -> {
                    user.setUsername(userToUpdate.getUsername());
                    user.setEmail(userToUpdate.getEmail());
                    user.setPassword(userToUpdate.getPassword());
                    return userRepository.save(user);
                }).orElseThrow(() -> new UserNotFoundException(userToUpdate.getId()));
    }

    public boolean checkIfUserExists(String username) {
        return userRepository.existsByUsername(username);
    }
}
