package com.example.kosproject.repository;

import com.example.kosproject.model.entity.Auth;
import com.example.kosproject.model.entity.RequestService;
import com.example.kosproject.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.auth.email = :email")
    User findByEmail(String email);
}
