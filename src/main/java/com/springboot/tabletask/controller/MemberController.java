package com.springboot.tabletask.controller;

//http://localhost:8080/swagger-ui.html

import com.springboot.tabletask.data.dto.response.ChangeNameRequestDto;
import com.springboot.tabletask.data.dto.response.ResponseMemberDto;
import com.springboot.tabletask.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/member")
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/get")
    public ResponseEntity<ResponseMemberDto> getMember(@RequestParam String email) throws  Exception {
        ResponseMemberDto responseMemberDto = memberService.getMember(email);

        return ResponseEntity.status(HttpStatus.OK).body(responseMemberDto);
    }

    @PutMapping("/put")
    public ResponseEntity<ResponseMemberDto> changeMemberName(@RequestBody ChangeNameRequestDto changeNameRequestDto) throws  Exception {
        ResponseMemberDto responseMemberDto = memberService.changeMemberName(changeNameRequestDto);

        return ResponseEntity.status(HttpStatus.OK).body(responseMemberDto);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteMember(String email) throws Exception {
        memberService.deleteMember(email);

        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }


}
