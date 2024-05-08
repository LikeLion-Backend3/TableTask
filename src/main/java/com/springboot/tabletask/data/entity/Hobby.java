package com.springboot.tabletask.data.entity;

// 다대일 단방향 매핑

import lombok.*;

import javax.persistence.*;

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
}
