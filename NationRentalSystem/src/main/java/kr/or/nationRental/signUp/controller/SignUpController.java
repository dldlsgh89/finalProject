package kr.or.nationRental.signUp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SignUpController {
	
	@RequestMapping(value="/goSignUp", method=RequestMethod.GET)
	public String goSignUp() {
		return "signUp/signUpForm";
	}
	
	@RequestMapping(value="/joinCongratulation", method=RequestMethod.GET)
	public String joinCongratulation() {
		
		return "signUp/joinCongratulation";
	}
	
}
