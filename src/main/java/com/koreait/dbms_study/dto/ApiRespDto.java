package com.koreait.dbms_study.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

// *5

public class ApiRespDto<T> {

    private String message;
//  성공/실패를 알려주는 message를 적어주는 매개변수 하나 만듬
    private T data;
// 실패를 했거나 잘 됬거나 msg로 넘기면 되는데..
// 유저조회를 하고 해당 유저 객체를 담아 전달하는데
// 이 타입이 user일지 post일지 모름(타입을 모름)

// 이때 Generic Type을 씀
// 그래서 T data를 추가함.
// 그러면 user든 post든 객체가 들어갈수도 있을것임

// 이제 UserRepository로




}
