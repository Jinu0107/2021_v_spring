package net.gondr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	@GetMapping("/")
	public String mainPage() {
		return "main";
	}
	
	@GetMapping("/test")
	public String sample(@RequestParam(value="age" , required=false , defaultValue="10") int age) {
		return "main";
	}
}
