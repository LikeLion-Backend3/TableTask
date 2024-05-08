package com.springboot.tabletask.data.dao.impl;

import com.springboot.tabletask.data.dao.MemberDAO;
import com.springboot.tabletask.data.entity.Member;
import com.springboot.tabletask.data.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class MemberDAOImpl implements MemberDAO {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberDAOImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member insertMember(Member member) {
        Member result = memberRepository.save(member);

        return member;
    }

    @Override
    public Member selectMember(String email) throws Exception {
        Optional<Member> member = memberRepository.findByEmail(email);

        if(member.isPresent()) {
            Member result = member.get();
            return  result;
        } else {
            throw new Exception("찾을 수 없음");
        }
    }

    @Override
    public Member updateMemberName(String email, String name) throws  Exception {
        Optional<Member> findMember = memberRepository.findByEmail(email);

        Member result;

        if(findMember != null) {
            Member member = findMember.get();

            member.setName(name);
            member.setUpdateAt(LocalDateTime.now());

            result = memberRepository.save(member);
        } else {
            throw new Exception("찾을 수 없음");
        }
        return result;
    }

    @Override
    public void deleteMember(String email) throws Exception {
        Optional<Member> findMember = memberRepository.findByEmail(email);
        
        if(findMember != null) {
            Member member = findMember.get();
            memberRepository.delete(member);
        } else {
            throw new Exception("찾을 수 없음");
        }
    }

}
