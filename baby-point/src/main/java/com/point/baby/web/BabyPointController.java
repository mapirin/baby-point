package com.point.baby.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class BabyPointController {

	@GetMapping("/")
	public String showPageIndex() {
		return "index";
	}
	
	@GetMapping("/point-execute")
	public String showPagePointExecute() {
		return "pointExecute";
	}
}
