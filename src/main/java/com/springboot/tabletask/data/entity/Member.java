package com.springboot.tabletask.data.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;

    @Column(nullable = false)
    private String name; //이름

    @Column(nullable = false)
    private String gender; //성별

    @Column(nullable = false)
    private Integer dateOfBirth; //생일

    @Column(nullable = false, unique = true)
    private Integer phoneNum; //휴대폰 번호

    @Column(nullable = false, unique = true)
    private String email; //이메일

    @Column(nullable = false, unique = true)
    private String userId; //아이디

    @Column(nullable = false, unique = true)
    private String password; //비밀번호

    @Column
    private LocalDateTime createAt;

    @Column
    private LocalDateTime updatedAt;

    @OneToOne //(mappedBy = "member")//일대일 양방향 매핑 추가
    //양방향 매핑을 유지하며 한쪽에만 외래키를 부여하기 위해 mappedBy 사용
//    @ToString.Exclude
    private  MemberDetail memberDetail;



    //일대다 매핑 (한 쪽 엔티티가 다른 쪽 엔티티를 여러 개 가질 수 있는 관계)
//    @Column (nullable = false)
//    private String description;

    // 다대일 단방향 매핑 추가
    @ManyToOne
    @JoinColumn(name = "hobby_id")
    @ToString.Exclude
    private Hobby hobby;
}
