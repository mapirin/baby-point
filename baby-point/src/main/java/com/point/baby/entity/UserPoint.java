package com.point.baby.entity;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class UserPoint{

	private String userName;
	private int point;
	private LocalDateTime updateTimestamp;

}
