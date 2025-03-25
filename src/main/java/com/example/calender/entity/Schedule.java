package com.example.calender.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Schedule {

    private Long id;
    private String todo;
    private String userPW;
    private String name;

    private String createdAt;
    private String updatedAt;

    public Schedule(String userPW, String name , String todo){

        this.userPW = userPW;
        this.name = name;
        this.todo = todo;
    }
    public Schedule(Long id , String userPW, String name , String todo,String createAt){
        this.id = id;
        this.userPW = userPW;
        this.name = name;
        this.todo = todo;
        this.createdAt = createAt;
    }
    /*
    * 일정 내용 업데이트
    */
    public void update(Long id,String userPW, String name , String todo){
        this.id = id;
        this.userPW = userPW;
        this.name = name;
        this.todo = todo;
    }
}
