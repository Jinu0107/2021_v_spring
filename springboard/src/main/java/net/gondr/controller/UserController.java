package net.gondr.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import net.gondr.domain.LoginDTO;
import net.gondr.domain.RegisterDTO;
import net.gondr.domain.UserVO;
import net.gondr.service.UserService;
import net.gondr.util.FileUtil;
import net.gondr.validator.RegisterValidator;

@Controller
@RequestMapping("/user/")
public class UserController {

	@Autowired
	private UserService service;

	@Autowired
	private ServletContext context;

	@GetMapping("register")
	public String viewRegisterPage(Model model) {
		model.addAttribute("registerDTO", new RegisterDTO());
		return "user/register";
	}

	@PostMapping("register")
	public String registerProcess(RegisterDTO registerDTO, Errors errors) throws Exception {

		new RegisterValidator().validate(registerDTO, errors);
		if (errors.hasErrors()) {
			return "user/register";
		}

		String uploadPath = context.getRealPath("/WEB-INF/upload");

		MultipartFile file = registerDTO.getProfileImg();
		String upFile = "";
//		업로드한 파일이 존재하면
		if (!file.getOriginalFilename().equals("")) {
			upFile = FileUtil.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
		}
		UserVO user = new UserVO();
		user.setImg(upFile);
		user.setName(registerDTO.getUsername());
		user.setPassword(registerDTO.getPassword());
		user.setUserid(registerDTO.getUserid());
		service.register(user);

		return "redirect:/";
	}

	@PostMapping("login")
	public String userLogin(LoginDTO loginDTO, HttpSession session, Model model) {
		
		if (loginDTO.getUserid().isEmpty() || loginDTO.getPassword().isEmpty()) {
			model.addAttribute("msg", "로그인 실패, 아이디와 비밀번호를 확인하세요");
			return "user/login";
		}

		UserVO user = service.login(loginDTO.getUserid(), loginDTO.getPassword());
		if (user == null) {
			model.addAttribute("msg", "로그인 실패, 아이디와 비밀번호를 확인하세요");
			return "user/login";
		}
		
		session.setAttribute("user", user);
		return "redirect:/";

	}

	@GetMapping("login")
	public String viewLoginPage(Model model) {
		model.addAttribute("loginDTO", new LoginDTO());
		return "user/login";
	}
	
	@GetMapping("logout")
	public String logOut(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/";
	}

}
