package com.springboot.tabletask.data.dao;

import com.springboot.tabletask.data.entity.Member;

//DAO 클래스는 인터페이스-구현체 구성으로 생성

public interface MemberDAO {
    Member insertLion(Member member);

    Member selectLion(String email) throws Exception;

    Member updateLionName(String email, String name) throws Exception;

    void deleteLion(String email) throws Exception;
}
