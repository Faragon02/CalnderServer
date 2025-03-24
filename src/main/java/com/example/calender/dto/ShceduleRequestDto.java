package com.example.calender.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ShceduleRequestDto {
    private String user_pw;
    private String name;
    private String todo;
}
