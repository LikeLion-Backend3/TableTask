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
}
