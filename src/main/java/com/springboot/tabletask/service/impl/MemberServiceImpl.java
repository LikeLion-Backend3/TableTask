package com.springboot.tabletask.service.impl;

import com.springboot.tabletask.data.dao.MemberDAO;
import com.springboot.tabletask.data.dto.RequestMemberDto;
import com.springboot.tabletask.data.dto.response.ChangeNameRequestDto;
import com.springboot.tabletask.data.dto.response.ResponseMemberDto;
import com.springboot.tabletask.data.entity.Member;
import com.springboot.tabletask.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberDAO memberDAO;

    @Autowired
    public MemberServiceImpl(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }

    @Override
    public ResponseMemberDto getMember(String email) throws Exception {
        Member member = memberDAO.selectMember(email);

        ResponseMemberDto responseMemberDto = new ResponseMemberDto();
        responseMemberDto.setPid(member.getPid());
        responseMemberDto.setName(member.getName());
        responseMemberDto.setGender(member.getGender());
        responseMemberDto.setDateOfBirth(member.getDateOfBirth());
        responseMemberDto.setPhoneNum(member.getPhoneNum());
        responseMemberDto.setEmail(member.getEmail());
        responseMemberDto.setUserId(member.getUserId());
        responseMemberDto.setPassword(member.getPassword());

        return responseMemberDto;
    }
    @Override
    public ResponseMemberDto saveMember(RequestMemberDto requestMemberDto) {
        Member member = new Member();
        member.setName(requestMemberDto.getName());
        member.setGender(requestMemberDto.getGender());
        member.setDateOfBirth(requestMemberDto.getDateOfBirth());
        member.setPhoneNum(requestMemberDto.getPhoneNum());
        member.setEmail(requestMemberDto.getEmail());
        member.setUserId(requestMemberDto.getUserId());
        member.setPassword(requestMemberDto.getPassword());
        member.setCreateAt(LocalDateTime.now());
        member.setUpdatedAt(LocalDateTime.now());

        Member savedMember = memberDAO.insertMember(member);

        ResponseMemberDto responseMemberDto = new ResponseMemberDto();
        responseMemberDto.setPid(savedMember.getPid());
        responseMemberDto.setName(savedMember.getName());
        responseMemberDto.setGender(savedMember.getGender());
        responseMemberDto.setDateOfBirth(savedMember.getDateOfBirth());
        responseMemberDto.setPhoneNum(savedMember.getPhoneNum());
        responseMemberDto.setEmail(savedMember.getEmail());
        responseMemberDto.setUserId(savedMember.getUserId());
        responseMemberDto.setPassword(savedMember.getPassword());

        return responseMemberDto;
    }

    @Override
    public ResponseMemberDto changeMemberName(ChangeNameRequestDto changeNameRequestDto) throws Exception {
        Member findMember = memberDAO.updateMemberName(changeNameRequestDto.getEmail(), changeNameRequestDto.getName());

        ResponseMemberDto responseMemberDto = new ResponseMemberDto();
        responseMemberDto.setPid(findMember.getPid());
        responseMemberDto.setName(findMember.getName());
        responseMemberDto.setGender(findMember.getGender());
        responseMemberDto.setDateOfBirth(findMember.getDateOfBirth());
        responseMemberDto.setPhoneNum(findMember.getPhoneNum());
        responseMemberDto.setEmail(findMember.getEmail());
        responseMemberDto.setUserId(findMember.getUserId());
        responseMemberDto.setPassword(findMember.getPassword());

        return responseMemberDto;
    }

    @Override
    public void deleteMember(String email) throws Exception {
        memberDAO.deleteMember(email);
    }
}
