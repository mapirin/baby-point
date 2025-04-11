package com.point.baby.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "user_point")
@Data
public class UserPoint{

	@Id
	private String userName;
	private int point;
	private LocalDateTime updateTimestamp;

}
