package com.springboot.tabletask.data.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "member_group")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String groupName;

    //일대다 단방향 매핑 (외래키 생성)
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id")
    private List<Member> members = new ArrayList<>();
}
