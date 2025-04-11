package com.point.baby.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class BabyPointController {

	@RequestMapping(value="/web")
	public String showPageTitle() {
		return "babyPointTitle";
	}
	
	@PostMapping("/web/point-menu")
	public String showPageMenu() {
		return "babyPointMenu";
	}
	
//	@PostMapping("/stock-execute")
//	public String showWindowStockExecute() {
//		return "stockExecute.html";
//	}
//	
//	@PostMapping("/use-execute")
//	public String showWindowUseExecute() {
//		return "useExecute.html";
//	}
}
