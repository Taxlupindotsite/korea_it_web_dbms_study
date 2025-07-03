package com.koreait.dbms_study.dto;

import com.koreait.dbms_study.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class EditUserReqDto {
//    *2
//    수정을 하려면
//    id, name, email을 받아야함
    private Integer userId;
    private String username;
    private String email;

//  정보를 User 객체에 담음

    public User toEntity(){
        return User.builder()
                .userId(this.userId)
                .username(this.username)
                .email(this.email)
                .build();
    }

//  User객체로 변환해서, Service로 넘김
//  그리고 쿼리 짤거임(user_mapper.xml으로)






}
