package kr.or.nationRental.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class testController {
	
	@RequestMapping(value="/getAddress", method=RequestMethod.GET)
	public String getAddress() {
		
		return "test";
	}
	
	
	
	
	



}
