package br.com.spring.anonymous.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ResetPasswordController {

	@RequestMapping("/resetPassword")
    public String resetPassword(){
		return "resetPassword";
    }
	
}
