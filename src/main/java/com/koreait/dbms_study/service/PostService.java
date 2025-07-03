package com.koreait.dbms_study.service;

import com.koreait.dbms_study.dto.AddPostReqDto;
import com.koreait.dbms_study.dto.ApiRespDto;
import com.koreait.dbms_study.dto.EditPostReqDto;
import com.koreait.dbms_study.entity.Post;
import com.koreait.dbms_study.entity.User;
import com.koreait.dbms_study.repository.PostRepository;
import com.koreait.dbms_study.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service


public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public ApiRespDto<?> addPost(AddPostReqDto addPostReqDto) {

//      TRY는 500오류등 떴을때 오류가 아니라 개발자가 캐치할수 있게
//      메시지를 띄워주는 용도
        try {
            Optional<User> optionalUser = userRepository.getUserByUserId(addPostReqDto.getUserId());
        if (optionalUser.isEmpty()) {
                return new ApiRespDto<>("존재하지 않는 유저입니다.", null);
            }
            int result = postRepository.addPost(addPostReqDto.toEntity());
        if (result == 0 ){
                return new ApiRespDto<>("문제가 발생했습니다.",null);
            }
            return new ApiRespDto<>("정상적으로 게시했습니다.",null);
        } catch (Exception e) {
            return new ApiRespDto<>("문제가 발생함.", e.getMessage());
        }

    }
//      <> 안
//    어제는 User넣고 머 null넣고 하는데
//    걍 와일드카드 넣어도 상관없을듯.. 정해져있는 객체가 없으니까
//    Integer 넣어도 되고..
//    insert나 update나 delete는 성공한 개수를 반환하니깐 integer 넣는거고..

    public ApiRespDto<Object> getPostByPostId(Integer postId){
     try {
         Optional<Post> optionalPost = postRepository.getPostByPostId(postId);
        if(optionalPost.isEmpty()) {
            return new ApiRespDto<>("해당 게시물이 ㅇ벗습니다.", null);

        }return new ApiRespDto<>("조회 성공",optionalPost.get());

     }  catch (Exception e){
         return new ApiRespDto<>("문제가 발생했습니다.",e.getMessage());
     }

    }

    public ApiRespDto<?> getPostList(){
        try {
            List<Post> postList = postRepository.getPostList();
            return new ApiRespDto<>("조회 완료", postList);

        }   catch (Exception e) {
            return new ApiRespDto<>("문제 발생",e.getMessage());
        }

    }

    public ApiRespDto<?> editPost(EditPostReqDto editPostReqDto) {
        try {
            Optional<Post> optionalPost = postRepository.getPostByPostId(editPostReqDto.getPostId());
            if(optionalPost.isEmpty()){
                return new ApiRespDto<>("해당 게시물은 존재하지 않습니다.", null);
            }
            int result = postRepository.editPost(editPostReqDto.toEntity());
            if(result != 1) {
                return new ApiRespDto<>("문제가 발생했습니다.", result);
            }
            return new ApiRespDto<>("수정 성공", result);
        } catch (Exception e) {
            return new ApiRespDto<>("문제가 발생했습니다.", e.getMessage());
        }
    }


    public ApiRespDto<?> removePost(Integer postId) {
        try {
            Optional<Post> optionalPost = postRepository.getPostByPostId(postId);
            if(optionalPost.isEmpty()){
                return new ApiRespDto<>("해당 게시물은 존재하지 않습니다.", null);
            }
            int result = postRepository.removePost(postId);
            if(result != 1) {
                return new ApiRespDto<>("문제가 발생했습니다.", result);
            }
            return new ApiRespDto<>("삭제 성공", result);
        } catch (Exception e) {
            return new ApiRespDto<>("문제가 발생했습니다.", e.getMessage());
        }
    }




}
