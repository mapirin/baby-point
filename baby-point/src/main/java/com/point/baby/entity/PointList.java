package com.point.baby.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Component
@Getter
@Setter
public class PointList {

	@Id
	private String recordId;
	private String userName;
	private String pointTitle;
	private int point;
	private String updateTimestamp;
}
