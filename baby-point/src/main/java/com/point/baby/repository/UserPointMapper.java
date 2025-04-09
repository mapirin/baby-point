package com.point.baby.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.point.baby.entity.UserPoint;

@Mapper
@Repository("userPoint")
public interface UserPointMapper {
	@Select("SELECT POINT FROM USER_POINT WHERE USER_NAME = #{userName}")
	int selectPointByUserName(String userName);
	
	@Update("UPDATE USER_POINT SET POINT = #{userPoint.point},UPDATE_TIMESTAMP = #{userPoint.updateTimestamp} WHERE USER_NAME = #{userPoint.userName}")
	void updateUserPoint(UserPoint userPoint);
}
