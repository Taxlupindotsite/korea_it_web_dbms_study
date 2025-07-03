package com.koreait.dbms_study.service;
import com.koreait.dbms_study.dto.AddUserReqDto;
import com.koreait.dbms_study.dto.ApiRespDto;
import com.koreait.dbms_study.dto.EditUserReqDto;
import com.koreait.dbms_study.entity.User;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.koreait.dbms_study.repository.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service

public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Map<String, String> addUser(AddUserReqDto addUserReqDto) {
        Map<String, String> response = new HashMap<>();
        int result = userRepository.addUser(addUserReqDto.toEntity(addUserReqDto));
    if (result == 1){
        response.put("status", "success");
        response.put("message", "추가 성공");
        return response;
    }
    response.put("status", "failed");
    response.put("message", "추가 실패");
    return response;

    }

    public List<User> getUserList() {
        return userRepository.getUserList();

    }

    public Map<String, Object> getUserByUserId(Integer userId) {
        Map<String, Object> response = new HashMap<>();
        Optional<User> user = userRepository.getUserByUserId(userId);
        if (user.isEmpty()) {
            response.put("message", "회원정보가 없습니다.");
            return response;
        }
        response.put("user", user);
        return response;

    }
//  *7
    public ApiRespDto<User> editUser(EditUserReqDto editUserReqDto) {
        Optional<User> user = userRepository.getUserByUserId(editUserReqDto.getUserId());
//  Optional -> 유효성 검사, 해당 userId가 존재하는지부터 봐야함
//  43줄에 있는거처럼. 단 userId가 editUserReqDto에 있는 getUserId로
    if (user.isEmpty()) {
    return new ApiRespDto<>("해당 유저가 존재하지 않습니다.", null);
    }
    int result = userRepository.editUser(editUserReqDto.toEntity());
//    업데이트가 만약 실패한경우?
//        결과는 0 아니면 1일텐데
        if(result == 0 ){
            return new ApiRespDto<>("문제가 발생했습니다.",null);
        }
    return new ApiRespDto<>("성공적으로 수정이 완료됨.",null);

    }

//  *8 마지막으로, UserController에서 호출하면 됨.

    public ApiRespDto<Integer> removeUser(Integer userId){
        Optional<User> user = userRepository.getUserByUserId(userId);
        if (user.isEmpty()) {
            return new ApiRespDto<>("해당 유저가 존재하지 않습니다.", null);
        }
    int result = userRepository.removeUser(userId);
    if(result == 0) {
        return new ApiRespDto<>("문제가 발생했습니다.", result);
    }
    return new ApiRespDto<>("성공적으로 삭제되었습니다.", result);
    }


    }




