package net.gondr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	@GetMapping("/hello")
	public String heelo(Model model , @RequestParam(value="name") String name) {
		
		model.addAttribute("msg" , "안녕하세요. JSP 마스터 " + name + "님");
		return "hello";
	}
	
	@GetMapping("/world/{name}")
	public String world(Model model , @PathVariable String name) {
		model.addAttribute("name" , name);
		return "world";
	}
	
	
}
