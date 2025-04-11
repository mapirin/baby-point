package com.point.baby.service;

import com.point.baby.entity.PointForm;

public interface PointExecuteService {
	
	public int selectPoint(String userName);
	public void updatePoint(PointForm pointForm);
}
