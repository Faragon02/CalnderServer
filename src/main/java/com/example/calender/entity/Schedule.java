package com.example.calender.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Schedule {

    private Long id;
    private String todo;
    private String user_pw;
    private String name;

    private String createdAt;
    private String updatedAt;

    public Schedule(String user_pw, String name , String todo){

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
