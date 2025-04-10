package com.point.baby.entity;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

//@Component
@Getter
@Setter
public class PointList{

	private String recordId;
	private String userName;
	private String pointId;
	private int point;
	private LocalDateTime updateTimestamp;
}
