package com.koreait.dbms_study.mapper;

import com.koreait.dbms_study.entity.Post;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper

public interface PostMapper {
    int addPost(Post post);


//    조회를 할 건데
//    Dto는 필요없고(postid로 조회할거니까)
//    entity도 필요없고
//      1.여기서부터
    Optional<Post> getPostByPostId(Integer postId);
    List<Post> getPostList();
//   이제 포스트매퍼.xml가서
    int editPost(Post post);
    int removePost(Integer postId);



}
