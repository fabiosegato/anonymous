package br.com.spring.anonymous.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class tbExceptionController {

	@RequestMapping("/tbException")
    public String exception(){
		return "tbException";
    }
	
}
