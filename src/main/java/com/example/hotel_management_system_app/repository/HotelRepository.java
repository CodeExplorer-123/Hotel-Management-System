package com.example.hotel_management_system_app.repository;

import com.example.hotel_management_system_app.entity.Hotel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,Integer> {
}
