package com.point.baby.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.point.baby.entity.UserPoint;

public interface UserPointRepository extends JpaRepository<UserPoint, String> {
	//表示するポイントを取得
	@Query("SELECT point FROM UserPoint WHERE userName = :userName")
	Integer findByUserName(@Param("userName")String userName);
}