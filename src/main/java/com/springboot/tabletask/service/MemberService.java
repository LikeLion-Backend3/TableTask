package com.springboot.tabletask.service;

import com.springboot.tabletask.data.dto.RequestMemberDto;
import com.springboot.tabletask.data.dto.response.ChangeNameRequestDto;
import com.springboot.tabletask.data.dto.response.ResponseMemberDto;

// 서비스 단에선 Entity 객체가 아닌 DTO를 매개로 통신

public interface MemberService {
    ResponseMemberDto getMember(String email) throws Exception;

    ResponseMemberDto saveMember(RequestMemberDto requestMemberDto);
    ResponseMemberDto changeMemberName(ChangeNameRequestDto changeNameRequestDto) throws Exception;

    void deleteMember(String email) throws  Exception;
}
