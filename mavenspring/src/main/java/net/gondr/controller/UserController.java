package net.gondr.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.gondr.domain.UserVO;
import net.gondr.domain.YYSample2VO;
import net.gondr.domain.YYSampleVO;

@Controller
@RequestMapping("/user/")
public class UserController {

	
	@RequestMapping(value = "regist", method = RequestMethod.GET)
	public String viewRegistPage() {
		return "user/regist";
	}

	@RequestMapping(value = "regist", method = RequestMethod.POST)
	public String registProcess(YYSampleVO user) {
		return "redirect:/world/" + user.getUserid();
	}

	@RequestMapping(value = "regist2", method = RequestMethod.GET)
	public String viewRegist2Page() {
		return "user/regist2";
	}

	@RequestMapping(value = "regist2", method = RequestMethod.POST)
	public String regist2Process(YYSample2VO user, Model model) {

		if (user.getUserid().equals("") || user.getPass().equals("") || user.getPassc().equals("")
				|| user.getName().equals("") || user.getEmail().equals("")) {
			return "redirect:/user/regist2";
		}

		if (!user.getPass().equals(user.getPassc())) {
			return "redirect:/user/regist2";
		}
		model.addAttribute("msg", user.toString());
		return "user/view";
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String viewLoginPage() {
		return "user/login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String loginProcess(UserVO user, HttpSession session) {
		if (user.getUserid().equals("gondr") && user.getPassword().equals("1234")) {
			session.setAttribute("user", user);
			session.removeAttribute("err_msg");
			return "redirect:/"; // 메인페이지로 이동
		}else {
			session.setAttribute("err_msg", "아이디 또는 비밀번호가 잘못되었습니다.");
			return "redirect:/user/login"; 
		}
	}
	
	@GetMapping("logout")
	public String logoutProcess(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/";
	}
	
	@GetMapping("info")
	public String viewInfoPage(HttpSession session) {
		return "user/info";
	}
}


















