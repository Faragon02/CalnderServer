package com.example.calender.dto;

import lombok.Getter;

@Getter
public class ScheduleRequestDto {
    private Long id;
    private String todo;
    private String user_pw;
    private String name;

    private String createdAt;
    private String updatedAt;
}
