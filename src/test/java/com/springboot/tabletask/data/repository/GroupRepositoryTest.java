package com.springboot.tabletask.data.repository;

import com.springboot.tabletask.data.entity.Group;
import com.springboot.tabletask.data.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class GroupRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    GroupRepository groupRepository;

    @Test
    void relationshipTest() {
        //테스트 데이터 생성

        Member member = new Member();
        member.setName("최멋사");
        member.setGender("남성");
        member.setDateOfBirth(010101);
        member.setPhoneNum(010-1234-5678);
        member.setEmail("babylion@likelion.org");
        member.setUserId("lion");
        member.setPassword("1234");

        memberRepository.save(member);

        Group group = new Group();
        group.setGroupName("회원 그룹");
        group.getMembers().add(member);

        groupRepository.save(group);
        List<Member> members = groupRepository.findById(1L).get().getMembers();

        for(Member foundMember : members) {
            System.out.println(member);
        }
    }
}
