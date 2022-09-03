package inha.capstone.ppanggeure.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;

@Controller
public class HomeController {

	//개발 페이지
	@GetMapping(value="/")
	public String index() throws Exception {
		return "index";
	}

	@GetMapping(value="/home")
	public String home() throws Exception {
		return "home";
	}

}
