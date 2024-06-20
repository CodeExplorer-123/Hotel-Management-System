package com.example.hotel_management_system_app.responentitymodel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseEntityModel<T> {
    private String message;
    private int statusCode;
    private T data;
}
