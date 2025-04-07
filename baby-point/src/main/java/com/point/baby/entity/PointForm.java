package com.point.baby.entity;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class PointForm {

	private String userName;
	private String pointId;
	private int point;
}
