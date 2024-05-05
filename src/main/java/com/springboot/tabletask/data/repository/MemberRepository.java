package com.springboot.tabletask.data.repository;

import com.springboot.tabletask.data.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//사용할 Repository 에 Spring-Data-JPA(JPARepository) 를 상속
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);
}
