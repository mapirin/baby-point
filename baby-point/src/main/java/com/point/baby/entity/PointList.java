package com.point.baby.entity;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Component
@Getter
@Setter
public class PointList implements PointIf{

	@Id
	private String recordId;
	private String userName;
	private String pointId;
	private int point;
	private LocalDateTime updateTimestamp;
}
