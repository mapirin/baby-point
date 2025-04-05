package com.point.baby.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.point.baby.entity.PointList;

public interface PointListRepository extends JpaRepository<PointList, String> {

}
