package net.gondr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	//메인페이지 라우팅
	@GetMapping("/")
	public String mainPage(Model model) {
		model.addAttribute("msg" , "양영디지털고등학교 도제반");
		return "main";
	}
	
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
