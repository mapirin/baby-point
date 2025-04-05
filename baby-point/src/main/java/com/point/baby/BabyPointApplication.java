package com.point.baby;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.point.baby")
public class BabyPointApplication {

	public static void main(String[] args) {
		SpringApplication.run(BabyPointApplication.class, args);
	}

}
