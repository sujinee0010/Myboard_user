package com.example.MyBoard.user.mapper;
import com.example.MyBoard.user.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository("com.example.MyBoard.user.mapper.UserMapper")
public interface UserMapper {
    //회원가입
    public void join(User user) throws Exception;
    //로그인
    public User login(String id , String pw) throws Exception;
    //ID와 PW 통해서 로그인,일치하는 User 객체 들고 오기
    //탈퇴
    public void deleteUser(String id)throws Exception;
    //중복 검사
    public int checkId(String id) throws Exception;
    //수정
    public int updateUser(String id,String name,String gender) throws Exception;

}
