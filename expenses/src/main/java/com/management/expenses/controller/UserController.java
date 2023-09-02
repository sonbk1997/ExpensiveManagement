package com.management.expenses.controller;

import com.management.expenses.model.User;
import com.management.expenses.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        System.out.println("Create a User Controller");
        this.userService = userService;
    }

    @GetMapping
    public List<User> findAllUser() {
        return userService.findAllUser();
    }

    @GetMapping("/{id}")
    public Optional<User> findUserById(@PathVariable("id") long id) {
        return userService.findById(id);
    }

    @PostMapping
    public void saveUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @PutMapping
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
    }
}
