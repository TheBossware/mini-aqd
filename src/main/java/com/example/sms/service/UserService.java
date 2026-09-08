package com.example.sms.service;

import com.example.sms.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User addUser(User user);
    List<User> getAll();
    User getById(Long id);
    void deactivateUser(Long id);
    void activateUser(Long id);
    User updateUser(Long id, User user);  //firs get the id to keep the existing user
    User findByEmployeeId(String employeeId);
    List<User> searchByName(String fullName);

}
