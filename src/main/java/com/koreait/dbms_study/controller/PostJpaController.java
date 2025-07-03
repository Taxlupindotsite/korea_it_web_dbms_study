package com.koreait.dbms_study.controller;

/* JPA
   객체 중심의 ORM(Object Relational Mapping)

   Mybatis처럼 쿼리를 짤 필요가 없음.
   객체 지향 언어(Java)의 객체와 관계형 DB 테이블 간에 매핑을 자동으로 처리함.
   SQL을 직접 쓰지않고 자바 객체중심으로 DB를 다름

   Hibernate는 JPA의 구현체다.
   JPA : 자바에서 ORM기술을 사용할 수 있게 만든 인터페이스임
   장점 : SQL없이 빠르게 CRUD 가능, 코드가 줄어듬
   단점 : 복잡한 쿼리는 어렵고, 디버깅이 힘듬

   얘는 매퍼,매퍼스 필요없음


 */

import com.koreait.dbms_study.dto.AddPostReqDto;
import com.koreait.dbms_study.service.PostJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jpa/post")

public class PostJpaController {

    @Autowired
    private PostJpaService postJpaService;

    @PostMapping("/add")
    public ResponseEntity<?> addPost(@RequestBody AddPostReqDto addPostReqDto){
        return ResponseEntity.ok(postJpaService.addPost(addPostReqDto));

    }

    @GetMapping("/get/list")
    public ResponseEntity<?> getPostList() {
        return ResponseEntity.ok(postJpaService.getPostList());
    }


}
