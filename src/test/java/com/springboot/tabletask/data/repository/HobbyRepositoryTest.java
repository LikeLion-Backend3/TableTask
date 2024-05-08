package com.springboot.tabletask.data.repository;

import com.springboot.tabletask.data.entity.Hobby;
import com.springboot.tabletask.data.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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

        Member member1 = new Member();
        member1.setName("최멋사");
        member1.setGender("남성");
        member1.setDateOfBirth(010101);
        member1.setPhoneNum(010-1234-5678);
        member1.setEmail("babylion@likelion.org");
        member1.setUserId("lion");
        member1.setPassword("1234");
        member1.setHobby(hobby);

        Member member2 = new Member();
        member2.setName("김멋사");
        member2.setGender("여성");
        member2.setDateOfBirth(020202);
        member2.setPhoneNum(010-5678-6552);
        member2.setEmail("babylion2@likelion.org");
        member2.setUserId("lion2");
        member2.setPassword("5678");
        member2.setHobby(hobby);

        Member member3 = new Member();
        member3.setName("최멋사");
        member3.setGender("남성");
        member3.setDateOfBirth(030303);
        member3.setPhoneNum(010-3210-5678);
        member3.setEmail("babylion3@likelion.org");
        member3.setUserId("lion3");
        member3.setPassword("4321");
        member3.setHobby(hobby);

        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);

//        System.out.println(
//                "babylion : " + memberRepository.findById(1L).orElseThrow(RuntimeException::new));
//
//        System.out.println("hobby : " + memberRepository.findById(1L).orElseThrow(RuntimeException::new).getHobby());


        System.out.println("check 1");
        List<Member> members = hobbyRepository.findById(hobby.getId()).get()
                .getMemberList();


        for (Member member : members) {
            System.out.println(member);
        }
    }
}
