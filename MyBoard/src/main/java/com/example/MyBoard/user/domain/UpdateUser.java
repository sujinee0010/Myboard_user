package com.example.MyBoard.user.domain;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UpdateUser {

    private String name;
    private String gender;


 //  public UpdateUser(){};

    public UpdateUser(String name , String gender) {
        this.name = name;
        this.gender = gender;
    }

}