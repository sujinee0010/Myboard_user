package com.example.MyBoard;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value= {"com.example.MyBoard.user.mapper"})
public class MyBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBoardApplication.class, args);
	}

}
