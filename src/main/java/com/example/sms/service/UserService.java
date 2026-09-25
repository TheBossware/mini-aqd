package com.example.sms.service;

import com.example.sms.dto.user.UserCreateRequest;
import com.example.sms.dto.user.UserResponse;
import com.example.sms.dto.user.UserUpdateRequest;
import com.example.sms.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserResponse addUser(UserCreateRequest request);
    List<UserResponse> getAll();
    UserResponse getById(Long id);
    void deactivateUser(Long id);
    void activateUser(Long id);
    UserResponse updateUser(Long id, UserUpdateRequest user);  //firs get the id to keep the existing user
    UserResponse findByEmployeeId(String employeeId);
    List<UserResponse> searchByName(String fullName);

}
