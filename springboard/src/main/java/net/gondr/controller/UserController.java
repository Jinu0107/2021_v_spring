package net.gondr.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.annotation.JsonAppend.Attr;

import net.gondr.domain.RegisterDTO;
import net.gondr.service.UserServiceImpl;
import net.gondr.util.FileUtil;

@Controller
@RequestMapping("/user/")
public class UserController {
	
	@Autowired
	private UserServiceImpl service;
	
	@Autowired
	private ServletContext context;
	
	@GetMapping("register")
	public String viewRegisterPage() {
		return "user/register";
	}
	
	@PostMapping("register")
	public String registerProcess(RegisterDTO dto) throws Exception{
		String uploadPath = context.getRealPath("/WEB-INF/upload");
		System.out.println(uploadPath);
		
		MultipartFile file = dto.getProfileImg();
		String upFile = FileUtil.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
		System.out.println(uploadPath + "에 " + upFile + "로 업로드 되었습니다.");
		return "user/register";
	}

}
