package com.springboot.tabletask.data.repository;

import com.springboot.tabletask.data.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
