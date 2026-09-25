package com.example.sms.service.impl;

import com.example.sms.dto.user.UserCreateRequest;
import com.example.sms.dto.user.UserMapper;
import com.example.sms.dto.user.UserResponse;
import com.example.sms.dto.user.UserUpdateRequest;
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
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    @Override
    public UserResponse addUser(UserCreateRequest request) {
        User user = userMapper.toEntity(request);
        user.setCreatedAt(LocalDateTime.now());
        User savedUser = userRepository.save(user);
        return userMapper.toResponse(savedUser);
    }

    @Override
    public List<UserResponse> getAll() {
        return userRepository.findAll().stream().map(userMapper::toResponse).toList();
    }

    @Override
    public UserResponse getById(Long id) {   // do not forget to check if it exists, if not throw an error
        User user =  userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User does not exist with id" + id));
        return userMapper.toResponse(user);
    }

    @Override
    public void deactivateUser(Long id){
        User user = userRepository.findById(id).
                orElseThrow(()-> new RuntimeException("User does not exists: "+id));
        user.setActive(false);
        userRepository.save(user);
    }

    @Override
    public void activateUser(Long id){
        User user = userRepository.findById(id).
                orElseThrow(()-> new RuntimeException("User does not exits: " + id));
        user.setActive(true);
        userRepository.save(user);
    }

    @Override
    public UserResponse updateUser(Long id, UserUpdateRequest user){
        User existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User does not exists: "+ id));
        existingUser.setFullName(user.fullName());
        existingUser.setCompany(user.company());
        existingUser.setDepartment(user.department());
        existingUser.setEmail(user.email());
        existingUser.setRole(user.role());
        User savedUser = userRepository.save(existingUser);
        return userMapper.toResponse(savedUser);
    }

    @Override
    public UserResponse findByEmployeeId(String employeeId){
        User user = userRepository.findByEmployeeId(employeeId)
                .orElseThrow(() -> new RuntimeException("The employee does not exist! Employee id: "+ employeeId));
        return userMapper.toResponse(user);
    }

    @Override
    public List<UserResponse> searchByName(String fullName){
        List<User> users = userRepository.findByFullNameContainingIgnoreCase(fullName);
        return users.stream().map(userMapper::toResponse).toList();
    }
    // stream listeyi tek tek banda koyar bu olmasaydı klasik bir for döngüsü ile yapılabilirdi

}
