package com.example.calender.dto;

import com.example.calender.entity.Schedule;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class ScheduleResponseDto {
    private Long id;
    @Getter(onMethod = @__( @JsonIgnore))
    private String userPw;
    private String name;
    private String todo;
    private String created_at;
    private String updated_at;


    public ScheduleResponseDto(Schedule schedule){
        this.id = schedule.getId();
        this.userPw = schedule.getUserPw();
        this.name = schedule.getName();
        this.todo = schedule.getTodo();
        this.created_at =schedule.getCreated_at();
        this.updated_at =schedule.getUpdated_at();
    }

    public ScheduleResponseDto(Long id, String userPw, String name, String todo, String created_at, String updated_at) {
        this.id = id;
        this.userPw = userPw;
        this.name = name;
        this.todo = todo;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}
