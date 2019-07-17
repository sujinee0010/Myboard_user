package com.example.MyBoard.user.domain;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class LoginUserDto {

    private String id;
    private String name;

    public  LoginUserDto(String id, String name){
        this.id = id;
        this.name = name;
    }


}
