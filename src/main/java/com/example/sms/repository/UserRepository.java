package com.example.sms.repository;

import com.example.sms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmployeeId(String employeeId);   /* using optional because the id might or might not exist
     keep that in mind*/
    List<User> findByFullNameContainingIgnoreCase(String fullName);
}
