package com.example.hotel_management_system_app.service;

import com.example.hotel_management_system_app.entity.Hotel;
import com.example.hotel_management_system_app.entity.User;
import com.example.hotel_management_system_app.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotel> getAllHotels(){
        return hotelRepository.findAll();
    }

    public Hotel getHotelById(int id) {
        Optional<Hotel> hotel = hotelRepository.findById(id);
        return hotel.orElse(null);
    }

    public Hotel createHotel(Hotel hotel){
        return hotelRepository.save(hotel);
    }

    public Hotel updateHotel(int id, Hotel hotelDetails) {
        Optional<Hotel> optionalHotel = hotelRepository.findById(id);
        if (optionalHotel.isPresent()) {
            Hotel existingHotel = optionalHotel.get();
            existingHotel.setName(hotelDetails.getName());
            existingHotel.setAddress(hotelDetails.getAddress());
            existingHotel.setRoomtype(hotelDetails.getRoomtype());
            // Set other fields as needed
            return hotelRepository.save(existingHotel);
        } else {
            return null; // Handle not found case as needed
        }
    }
}
