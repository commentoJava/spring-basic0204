package com.example.lecture.chap04.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private String statusCode;
    private String message;
}
