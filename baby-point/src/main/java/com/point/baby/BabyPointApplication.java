package com.point.baby;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.point.baby")
@ComponentScan(basePackages = {"com.example.service"})
@MapperScan(basePackages = {"com.example.mapper"})
public class BabyPointApplication {

	public static void main(String[] args) {
		SpringApplication.run(BabyPointApplication.class, args);
	}

}
