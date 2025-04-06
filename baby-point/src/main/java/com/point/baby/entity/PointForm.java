package com.point.baby.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PointForm {

	private String recordId;
	private String userName;
	private String pointTitle;
	private int point;
	private Long updateTimestamp;
}
