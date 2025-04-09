package com.point.baby.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.point.baby.entity.PointList;


@Mapper
@Repository("pointList")
public interface PointListMapper {
	@Insert("INSERT INTO POINT_LIST(RECORD_ID, USER_NAME, POINT_ID, POINT, UPDATE_TIMESTAMP"
			+ ")VALUE("
			+ "#{pointList.recordId}, #{pointList.userName}, #{pointList.pointId}, #{pointList.point}, #{pointList.updateTimestamp}")
	void insertPointList(PointList pointList);
	
}
