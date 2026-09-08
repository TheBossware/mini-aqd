package com.example.sms.service.impl;

import com.example.sms.entity.User;
import com.example.sms.repository.UserRepository;
import com.example.sms.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User addUser(User user) {
        user.setCreatedAt(LocalDateTime.now());
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) {   // do not forget to check if it exists, if not throw an error
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User does not exist with id" + id));
    }

    @Override
    public void deactivateUser(Long id){
        User user = getById(id);
        user.setActive(false);
        userRepository.save(user);
    }

    @Override
    public void activateUser(Long id){
        User user = getById(id);
        user.setActive(true);
        userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User user){
        User existingUser = getById(id);
        existingUser.setFullName(user.getFullName());
        existingUser.setCompany(user.getCompany());
        existingUser.setDepartment(user.getDepartment());
        existingUser.setEmail(user.getEmail());
        existingUser.setEmployeeId(user.getEmployeeId());
        existingUser.setRole(user.getRole());
        return userRepository.save(existingUser);
    }

    @Override
    public User findByEmployeeId(String employeeId){
        return userRepository.findByEmployeeId(employeeId)
                .orElseThrow(() -> new RuntimeException("The employee does not exist! Employee id: "+ employeeId));
    }

    @Override
    public List<User> searchByName(String fullName){
        return userRepository.findByFullNameContainingIgnoreCase(fullName);
    }

}
