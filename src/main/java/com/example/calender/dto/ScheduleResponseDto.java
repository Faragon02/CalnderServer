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
    private String userPW;
    private String name;
    private String todo;
    private String createdAt;
    private String updatedAt;


    public ScheduleResponseDto(Schedule schedule){
        this.id = schedule.getId();
        this.userPW = schedule.getUserPW();
        this.name = schedule.getName();
        this.todo = schedule.getTodo();
        this.createdAt =schedule.getCreatedAt();
        this.updatedAt =schedule.getUpdatedAt();
    }

    public ScheduleResponseDto(long l, String userPW, String name, String todo, String createdAt, String updatedAt) {
        this.id = l;
        this.userPW = userPW;
        this.name = name;
        this.todo = todo;
        this.createdAt =createdAt;
        this.updatedAt = updatedAt;
    }
}
