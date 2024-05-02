package com.example.springbootcrudapp.controllers;

import com.example.springbootcrudapp.entities.UserEntity;
import com.example.springbootcrudapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<UserEntity> findAll() {
        List<UserEntity> users = userService.findAll();
        return users;
    }

    @GetMapping("/deleted/{id}")
    public void deletedUserById(@PathVariable Long id) {
        userService.deletedUser(id);

    }

    @PostMapping("/add")
    public UserEntity addUser(@RequestBody UserEntity user) {
        return userService.saveUser(user);
    }

    @GetMapping("/find/{id}")
    public Optional<UserEntity> findUserById(@PathVariable Long id) {
        return userService.findById(id);

    }


}
