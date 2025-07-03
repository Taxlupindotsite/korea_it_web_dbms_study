package com.koreait.dbms_study.controller;

import com.koreait.dbms_study.dto.AddUserReqDto;
import com.koreait.dbms_study.dto.EditUserReqDto;
import com.koreait.dbms_study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//mybatis
//SQL 중심의 데이터 접근 프레임워크
// -> 내가 직접 SQL문 작성하고, 그 결과를 JAVA 객체로 매핑
//SQL을 직접짜기 때문에 완전히 통제 가능 (자유도 높음), 대신 코드가 복잡하고 반복적이다.
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody AddUserReqDto addUserReqDto) {
        return ResponseEntity.ok(userService.addUser(addUserReqDto));
    }

    @GetMapping("/get/list")
    public ResponseEntity<?> getUserList(){
        return ResponseEntity.ok(userService.getUserList());

    }
    @GetMapping("/get/{userId}")
    public ResponseEntity<?> getUserByUserId(@PathVariable Integer userID){
        return ResponseEntity.ok(userService.getUserByUserId(userID));

    }

//    수정과 삭제 (여기서부터 시작)
//    요청 메소드 중 Delete, put이 있는데,
//    수정과 삭제도 Post로 해 볼것임
//    이유 : 보안과 호환성
//    일부 브라우저, 서버가 put과 delete를 완벽히 지원 안하는 경우 있음
//    예를들어 html 폼 태그(<form>)가 Get과 Post만 지원함

//    *1(처음, UserController에서) -> EditUserReqDto로
    @PostMapping("/edit")
//    *8(마지막)
    public ResponseEntity<?> editUser(@RequestBody EditUserReqDto editUserReqDto) {
        return ResponseEntity.ok(userService.editUser(editUserReqDto));

    }

// 다시 흐름 정리,
// *1의 PostMapping으로 요청이 들어올것임.

//  RequestBody가 Json 데이터를 받음.
//  JSON으로 들어온 데이터를 Body가 ReqDto형태로 변환함.(자바객체)
//  이걸 Service에 있는 EditUser로 넘김.

//  매개변수로 그걸 받고, EditUserReqDto 안에는 UserID가 들어있을텐데
//  수정 전 유효성 검사.(if문)

    /* 더 자세히 설명하면..
    UserMapper에 editUser(User user)에서..
    ReqDto형태가 아니라, User 객체로 받고있음.
    User 객체의 내용으로 SQL문에서 수정을 함.

    +처음받은건 Req.Dto인데,
    결국엔 User 객체로 보내야하므로 변환과정(메소드) 필요함
    변환과정은 toEntity메소드는 editUserReqDto 클래스에 있음

    메소드를 호출하면,
    builder를 통해서 user라는 객체를 만듬
    메소드 역할은
    Req.dto에서 받아온 id,name,email를 user에넣어주는 것

    this는 자기자신의 객체인데, 그 객체에 들어잇는걸 뺴서
    User 객체에 넣고있음.

    return은 결국 유저이므로, 이렇게 빌더를 이용해서
    데이터가 들어갈거고 데이터가 들어간 user 객체를
    return을 해줄것임.

    그러면 Service에서, 처음 요청받은 reqDTO가 User로 변환되었고
    editUser는 이제 User객체를 받으므로, 작업이 가능.

    -----------------------------------------------------------------
    editUser로 가보면, User 객체를 받고있고,
    (UserRepository에서) UserMapper에 있는 editUser에게 넘김.(return)

    인터페이스 UserMapper로 가면 editUser가 구현되있지 않은 추상메소드인데,
    얘를 누가 구현을 하냐면, SQL문이 구현을 함.

    usermapper의 메소드 이름이 editUser이므로,
    editUser로 구현이 됨.
    이제 set 해서 어떤 내용을 변경할건지 주루룩 씀
    결국 user객체 안에 있는 데이터를 수정을 함

    ---------------------------------------------------------------------
    이게 실행이 되면 if문으로 넘어감.
    리턴값은 성공했으면 1이 담길거고, 실패하면 0이 담길것임.
    (UserMapper의 editUser가 int로 선언됬으니까)

    이제 int result에서 0아니면 1이 담기게 될것임.
    그럼 메시지 출력.

    리턴된 애는 UserController안에 들어갈 텐데,
    그 결과물은 ApiResponseDto -> Body안에 담겨서 클라이언트(웹)에 리턴이 됨.

     */

    @PostMapping("/remove")
    public ResponseEntity<?> removeUser(@RequestParam Integer userId) {
        return ResponseEntity.ok(userService.removeUser(userId));

    }






}