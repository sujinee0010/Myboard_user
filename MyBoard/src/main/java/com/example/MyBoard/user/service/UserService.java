package com.example.MyBoard.user.service;

import com.example.MyBoard.user.domain.LoginUserDto;
import com.example.MyBoard.user.domain.UpdateUser;
import com.example.MyBoard.user.domain.User;
import com.example.MyBoard.user.domain.CheckUserID;
import com.example.MyBoard.user.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public void joinUserService(User user) {
        try{
            if(userMapper.checkId(user.getId()) == 0)
                userMapper.join(user);
        }
        catch (Exception e){
        }

    }
    public LoginUserDto loginUserService(String id , String pw) {
        try {
            //유저 객체 들고와서
            // 그 객체의 이름과 id만 가진 객체 호출
            User user = userMapper.login(id,pw);
            return new LoginUserDto(user.getId(),user.getName());
        }
        catch (Exception e) {
            return  null;
        }
    }

    public void deletUserService(String id){
        try{
            userMapper.deleteUser(id);
        }
        catch (Exception e)
        {
        }
    }

    public  void updateUserService(UpdateUser updateUser,String id){
        try{
            userMapper.updateUser(id,updateUser.getName(),updateUser.getGender());
        }
        catch (Exception e)
        {
        }
    }


}
