package com.example.calender.dto;

import com.example.calender.entity.Schedule;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ScheduleResponseDto {
    private Long id;
    @Getter(onMethod = @__( @JsonIgnore))
    private String user_pw;
    private String name;
    private String todo;
    private String createdAt;
    private String updatedAt;


    public ScheduleResponseDto(Schedule schedule){
        this.id = schedule.getId();
        this.user_pw = schedule.getUser_pw();
        this.name = schedule.getName();
        this.todo = schedule.getTodo();
        this.createdAt =schedule.getCreatedAt();
        this.updatedAt =schedule.getUpdatedAt();
    }

    public ScheduleResponseDto(long l, String userPw, String name, String todo) {
        this.id = l;
        this.user_pw = userPw;
        this.name = name;
        this.todo = todo;
    }
}
