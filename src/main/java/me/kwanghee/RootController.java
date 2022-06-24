package me.kwanghee;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RootController {
	
	@GetMapping("/")
	@ResponseBody
	public String index() {
		return "Sprng Boot + JPA 를 이용한 게시판 만들기 demo";
	}
}
