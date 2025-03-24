package com.example.calender.dto;

import com.example.calender.entity.Shcedule;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

@Getter
public class ShceduleResponseDto {
    private Long id;
    @Getter(onMethod = @__( @JsonIgnore))
    private String user_pw;
    private String name;
    private String todo;

    public ShceduleResponseDto(Shcedule shcedule){
        this.id = shcedule.getId();
        this.user_pw = shcedule.getUser_pw();
        this.name = shcedule.getName();
        this.todo = shcedule.getTodo();
    }
}
