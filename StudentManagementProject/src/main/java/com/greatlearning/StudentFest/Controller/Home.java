package com.greatlearning.StudentFest.Controller ;

import org.springframework.stereotype.Controller ;

import org.springframework.web.bind.annotation.RequestMapping ;

    @Controller
    @RequestMapping("/")
    public class Home {
	 
	@RequestMapping("/hello")
	
	public String showHomePage() {
	
	System.out.println("Working") ;
	
	return "home" ;
	
	}

}
