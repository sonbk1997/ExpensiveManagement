package com.management.expenses.controller;

import com.management.expenses.model.User;
import com.management.expenses.services.UserService;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    @GetMapping("/all")
    public List<User> findAllUser() {
        return userService.findAllUser();
    }

    @GetMapping("/page/{page}")
    public Object findAllUserByPage(@PathVariable("page") int page) {
        Page<User> pageUser = userService.findByPage(page);

        List<User> listUser = pageUser.getContent();

        List<User> numberOfAllUsers = userService.findAllUser();

        Map<String, Object> object = new HashMap<>();
        object.put("page", page);
        object.put("per_page", 5);
        object.put("total", numberOfAllUsers.size());
        object.put("total_pages", numberOfAllUsers.size()/5 + 1);
        object.put("data", listUser);

        return object;
    }

    @GetMapping("/{id}")
    public Optional<User> findUserById(@PathVariable("id") long id) {
        return userService.findById(id);
    }

    @PostMapping
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
    }
}
