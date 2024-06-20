package com.example.hotel_management_system_app.repository;

import com.example.hotel_management_system_app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
