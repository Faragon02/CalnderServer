package com.example.calender.entity;


import lombok.Getter;

@Getter
//@AllArgsConstructor 되도록 사용 하지 않는 것이 좋음.
public class Schedule {

    private Long id;
    private String userPw;
    private String name;
    private String todo;
    private String created_at;
    private String updated_at;

    public Schedule(String userPw, String name , String todo){

        this.userPw = userPw;
        this.name = name;
        this.todo = todo;
    }

    public Schedule(Long id, String userPw, String name, String todo, String created_at, String updated_at) {
        this.id = id;
        this.userPw = userPw;
        this.name = name;
        this.todo = todo;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}
