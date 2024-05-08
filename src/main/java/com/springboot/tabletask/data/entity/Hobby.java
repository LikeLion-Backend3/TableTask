package com.springboot.tabletask.data.entity;

// 다대일 단방향 매핑

import javassist.bytecode.annotation.MemberValue;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
//@EqualsAndHashCode(callSuper = true)
@Table(name = "hobby")
public class Hobby {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String hobby;

    // 다대일 양방향 매핑
    @OneToMany(mappedBy = "hobby", fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<Member> memberList = new ArrayList<>();
}
