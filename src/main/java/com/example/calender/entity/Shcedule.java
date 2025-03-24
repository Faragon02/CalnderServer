package com.example.calender.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Shcedule {

    @Setter
    private Long id;
    private String todo;
    private String user_pw;
    private String name;

    private String created_date;
    private String updated_date;

    public Shcedule(String user_pw, String name , String todo){

        this.user_pw = user_pw;
        this.name = name;
        this.todo = todo;
    }
    /*
    * 일정 내용 업데이트
    */
    public void update(String todo){
        this.todo = todo;
    }
}
