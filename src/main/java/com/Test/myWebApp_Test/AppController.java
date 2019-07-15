package com.Test.myWebApp_Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.Test.myWebApp_Test.service.LoginService;

@Controller
public class AppController {
	@Autowired
    LoginService service;
	
	
		@RequestMapping("/")
		public String welcome()
		{
			System.out.println("AppController--->Welcome");
			return "index";
		}
	/*
	 * @RequestMapping("/action") public String action() {
	 * System.out.println("AppController--->action"); return "action"; }
	 */

	    @RequestMapping(value="/action", method = {RequestMethod.POST},produces = "html/text")
	    public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password){
	    	System.out.println("showWelcomePage");
	        boolean isValidUser = service.validateUser(name, password);

	        if (!isValidUser) {
	            model.put("errorMessage", "Invalid Credentials");
	            return "index";
	        }

	        model.put("name", name);
	        model.put("password", password);

	        return "action";
	    }

		

}