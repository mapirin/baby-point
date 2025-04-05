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
public class UserPoint {

	@Id
	private String userName;
	private int point;
	private String updateTimestamp;

}
