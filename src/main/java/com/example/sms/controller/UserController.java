package com.example.sms.controller;

import com.example.sms.dto.user.UserCreateRequest;
import com.example.sms.dto.user.UserResponse;
import com.example.sms.dto.user.UserUpdateRequest;
import com.example.sms.entity.User;
import com.example.sms.service.UserService;
import org.springframework.http.HttpStatus;
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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserResponse addUser(@RequestBody UserCreateRequest request){
        return userService.addUser(request);
    }

    @GetMapping
    public List<UserResponse> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserResponse getById(@PathVariable Long id){
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
    public UserResponse updateUser(@PathVariable Long id, @RequestBody UserUpdateRequest user){
        return userService.updateUser(id,user);
    }

    @GetMapping("/employee/{employeeId}")
    public UserResponse findByEmployeeId(@PathVariable String employeeId){
        return userService.findByEmployeeId(employeeId);
    }

    @GetMapping("/search")
    public List<UserResponse> searchByName(@RequestParam String fullName){
        return userService.searchByName(fullName);
    }

    /* RequestBody to convert json into java
    Pathvariable for a piece from url */

}
