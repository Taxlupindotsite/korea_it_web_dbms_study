package com.koreait.dbms_study.repository;

import com.koreait.dbms_study.entity.User;
import com.koreait.dbms_study.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    @Autowired
    private UserMapper userMapper;
    public int addUser(User user){
        return userMapper.insert(user);

    }

    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    public Optional<User> getUserByUserId(Integer userId){
        return userMapper.getUserByUserId(userId);

    }

//  *5
//  Map을 자꾸 만들어서 쓰는게 귀찮으니 Dto를 새로 하나 만들거임
//  ApiRespDto로

//  *6
    public int editUser(User user){
        return userMapper.editUser(user);
    }
//  Service에서 return을 부를건데
//  int로 올것임(0 or 1)


//  *7, UserService로

    public int removeUser(Integer userId) {
        return userMapper.removeUser(userId);

    }




}
