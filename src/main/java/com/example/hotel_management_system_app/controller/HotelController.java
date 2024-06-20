package com.example.hotel_management_system_app.controller;

import com.example.hotel_management_system_app.entity.Hotel;
import com.example.hotel_management_system_app.entity.User;
import com.example.hotel_management_system_app.service.HotelService;
import org.apache.catalina.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels(){
        List<Hotel> h = hotelService.getAllHotels();
        if(h.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(h,HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Hotel> getAllHotelById(@PathVariable int id){
        Hotel h = hotelService.getHotelById(id);
        if(h == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(h,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        try{
            hotelService.createHotel(hotel);
            return new ResponseEntity<>(hotel,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/id/{id}")
    public ResponseEntity<Hotel> updateUser(@PathVariable int id, @RequestBody Hotel hotel){
        Hotel h = hotelService.updateHotel(id,hotel);
        if(h == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(h,HttpStatus.OK);
    }
}
