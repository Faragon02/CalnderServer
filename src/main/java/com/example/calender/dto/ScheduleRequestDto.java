package com.example.calender.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

@Getter
public class ScheduleRequestDto {
    private Long id;
    private String userPw;
    private String name;
    private String todo;
    private String updated_at;
}
