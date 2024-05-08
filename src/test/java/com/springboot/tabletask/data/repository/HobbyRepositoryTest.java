package com.springboot.tabletask.data.repository;

import com.springboot.tabletask.data.entity.Hobby;
import com.springboot.tabletask.data.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HobbyRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    HobbyRepository hobbyRepository;

    @Test
    void relationTest1() {

        Hobby hobby = new Hobby();
        hobby.setHobby("알고리즘 문제풀이");

        hobbyRepository.save(hobby);

        Member member = new Member();
        member.setName("최멋사");
        member.setGender("남성");
        member.setDateOfBirth(010101);
        member.setPhoneNum(010-1234-5678);
        member.setEmail("babylion@likelion.org");
        member.setUserId("lion");
        member.setPassword("1234");
        member.setHobby(hobby);

        memberRepository.save(member);

        System.out.println(
                "babylion : " + memberRepository.findById(1L).orElseThrow(RuntimeException::new));

        System.out.println("hobby : " + memberRepository.findById(1L).orElseThrow(RuntimeException::new).getHobby());

    }
}
