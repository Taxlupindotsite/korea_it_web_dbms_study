package com.koreait.dbms_study.mapper;

import com.koreait.dbms_study.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

//  인터페이스는 선언/정의만 할뿐, 구현은 하지않음

@Mapper
public interface UserMapper {
    int insert(User user);
    List<User> getUserList();
    Optional<User> getUserByUserId(Integer userId);

//
//  *4 EditUser가 UserMapper에서 존재해야함. (인터페이스는 선언만 하므로)
    int editUser(User user);

//  *5 이제 UserRepository로

    int removeUser(Integer userId);


}
