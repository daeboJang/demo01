package me.kwanghee;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RootController {
	
	@GetMapping("/")
	@ResponseBody
	public String index() {
		return "Sprng Boot + JPA �� �̿��� �Խ��� ����� demo";
	}
}
