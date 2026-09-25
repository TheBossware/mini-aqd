package com.example.sms.dto.user;

import com.example.sms.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponse toResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getEmployeeId(),
                user.getFullName(),
                user.getDepartment(),
                user.getEmail(),
                user.getRole(),
                user.getActive(),
                user.getCompany(),
                user.getCreatedAt()
        );
    }

    public User toEntity(UserCreateRequest request){
        User user = new User();
        user.setEmployeeId(request.employeeId());
        user.setFullName(request.fullName());
        user.setDepartment(request.department());
        user.setEmail(request.email());
        user.setRole(request.role());
        user.setCompany(request.company());
        return user;
    }

    public void  updateEntityFromRequest(User user, UserUpdateRequest updatedRequest){
        user.setFullName(updatedRequest.fullName());
        user.setDepartment(updatedRequest.department());
        user.setEmail(updatedRequest.email());
        user.setRole(updatedRequest.role());
        user.setCompany(updatedRequest.company());
    }

}
