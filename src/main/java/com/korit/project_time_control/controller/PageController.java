package com.korit.project_time_control.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/todolist")
public class PageController {

	@GetMapping("/index")
	public String loadindex() {
		return "index";
	}

}
