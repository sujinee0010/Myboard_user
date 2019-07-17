package com.example.MyBoard.user.controller;

import com.example.MyBoard.user.domain.LoginUserDto;
import com.example.MyBoard.user.domain.UpdateUser;
import com.example.MyBoard.user.domain.User;
import com.example.MyBoard.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "USER JOIN", notes = "USER JOIN API")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "USER 등록 성공"),
            @ApiResponse(code = 400, message = "id or pw - NULL"),
            @ApiResponse(code = 409, message = "중복된 닉네임 또는 아이디"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @PostMapping(value = "/user")
    private ResponseEntity<Void>userJoin(@RequestBody User user){
        userService.joinUserService(user);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @ApiOperation(value = "USER LOGIN", notes = "USER LOGIN API")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "로그인 성공 ,유저 이름 "),
            @ApiResponse(code = 400, message = "id or pw - NULL"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @GetMapping(value = "/users/{id}")
    private ResponseEntity<LoginUserDto> userLogin(@PathVariable(value = "id") String id , String pw) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.loginUserService(id,pw));
    }

    // 회원 탈퇴
    @DeleteMapping(value = "/users/{id}")
    private  ResponseEntity<Void> userDelete(@PathVariable (value="id") String id){
        userService.deletUserService(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    //회원정보 수정- 이름 , 성별 수정
    @PatchMapping(value="/users/{id}")
    private ResponseEntity<Void>userUpdate(@RequestBody @Valid UpdateUser updateUser, @PathVariable (value="id") String id){
        userService.updateUserService(updateUser,id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
