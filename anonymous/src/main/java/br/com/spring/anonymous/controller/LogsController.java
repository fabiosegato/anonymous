package br.com.spring.anonymous.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogsController {

	@RequestMapping("/logs")
    public String logs(){
		return "logs";
    }
	
}
