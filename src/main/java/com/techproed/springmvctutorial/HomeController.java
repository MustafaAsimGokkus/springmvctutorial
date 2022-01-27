package com.techproed.springmvctutorial;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
// Controller annotation is used to indicate that this is a controller
//class for all methods 
@Controller
public class HomeController {
    //@RequestMapping() is used to make the method work as a request and to accept requests
	@RequestMapping("/")
	public String home() {
		return "index";
	}
}
