package br.com.spring.anonymous.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControlController {

	@RequestMapping("/control")
    public String resetPassword(){
		return "control";
    }
	
}
