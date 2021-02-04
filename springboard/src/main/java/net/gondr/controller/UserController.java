package net.gondr.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import net.gondr.domain.RegisterDTO;
import net.gondr.domain.UserVO;
import net.gondr.service.UserService;
import net.gondr.util.FileUtil;

@Controller
@RequestMapping("/user/")
public class UserController {

	@Autowired
	private UserService service;

	@Autowired
	private ServletContext context;

	@GetMapping("register")
	public String viewRegisterPage() {
		return "user/register";
	}

	@PostMapping("register")
	public String registerProcess(RegisterDTO dto) throws Exception {
		String uploadPath = context.getRealPath("/WEB-INF/upload");
//		System.out.println(uploadPath);

		MultipartFile file = dto.getProfileImg();
		String upFile = "";
//		업로드한 파일이 존재하면
		if (!file.getOriginalFilename().equals("")) {
			upFile = FileUtil.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
		}
		UserVO user = new UserVO();
		user.setImg(upFile);
		user.setName(dto.getUsername());
		user.setPassword(dto.getPassword());
		user.setUserid(dto.getUserid());
		service.register(user);

		return "redirect:/";
	}

}
