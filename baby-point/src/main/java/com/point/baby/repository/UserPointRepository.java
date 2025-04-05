package com.point.baby.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.point.baby.entity.UserPoint;

public interface UserPointRepository extends JpaRepository<UserPoint, String> {

}
