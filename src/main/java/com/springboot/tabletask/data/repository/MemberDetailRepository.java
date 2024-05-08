package com.springboot.tabletask.data.repository;

import com.springboot.tabletask.data.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberDetailRepository extends JpaRepository<Member, Long> {
}
