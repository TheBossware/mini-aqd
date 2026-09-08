package com.example.sms.controller;

import com.example.sms.entity.User;
import com.example.sms.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }
    @GetMapping("/{id}")
    public User getById(@PathVariable Long id){
        return userService.getById(id);
    }

    @PatchMapping("/{id}/deactivate")
    public void deactivateUser(@PathVariable Long id){
        userService.deactivateUser(id);
    }

    @PatchMapping("/{id}/activate")
    public void activateUser(@PathVariable Long id){
        userService.activateUser(id);
    }

    @PutMapping("/{id}")  //user already exists in url above
    public User updateUser(@PathVariable Long id, @RequestBody User user){
        return userService.updateUser(id,user);
    }

    @GetMapping("/employee/{employeeId}")
    public User findByEmployeeId(@PathVariable String employeeId){
        return userService.findByEmployeeId(employeeId);
    }

    @GetMapping("/search")
    public List<User> searchByName(@RequestParam String fullName){
        return userService.searchByName(fullName);
    }

    /* RequestBody to convert json into java
    Pathvariable for a piece from url */

}
