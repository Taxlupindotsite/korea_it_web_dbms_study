package com.koreait.dbms_study.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor


public class User {
    private Integer userId; // int는 null이 안되니 integer 추천
    private String username;
    private String email;
    private LocalDateTime createDt;
    private LocalDateTime updateDt;

}
