package com.example.MyBoard.user.domain;

import lombok.Getter;


@Getter
public class CheckUserID {

    private String id;

    public CheckUserID(String id){
        this.id = id;
    }
}
