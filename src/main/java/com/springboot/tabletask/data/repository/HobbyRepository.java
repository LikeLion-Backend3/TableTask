package com.springboot.tabletask.data.repository;

import com.springboot.tabletask.data.entity.Hobby;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HobbyRepository extends JpaRepository<Hobby, Long> {
}
