package com.springboot.tabletask.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


//일대일 단방향 매핑

@Entity
@Table(name = "member_detail")
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
// @EqualsAndHashCode(callSuper = true)
public class MemberDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @OneToOne(optional = false) //false로 바꿈으로써 열에는 값이 무조건 존재해야 한다
    @JoinColumn(name = "member_id")
    private Member member;
}
