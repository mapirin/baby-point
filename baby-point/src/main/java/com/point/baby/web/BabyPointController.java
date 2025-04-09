package com.point.baby.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class BabyPointController {

	@GetMapping("/")
	public String showPageIndex() {
		return "index";
	}
	
	@PostMapping("/point-execute")
	public String showPagePointExecute() {
		return "redirect:/pointExecute.html";
	}
}
