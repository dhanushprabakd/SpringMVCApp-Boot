package trng.imcs.app.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import trng.imcs.app.services.LoginValidation;

@Controller
public class AppController {

	
	@Autowired
	LoginValidation loginValidation;
	@RequestMapping("/")
	public String displayMenu(){
		return "login";
	}
	@RequestMapping("/login.do")
	public String validateUser(@RequestParam String userName, @RequestParam String password,Model model){
		
		HashMap<String,String> loginMap = new HashMap<>();
		loginMap.put("abc", "abc");
		loginMap.put("cba","cba");
		boolean validationFlag = loginValidation.ValidateCredentials(userName, password, loginMap);
		if(validationFlag){
			return "home";
		}else{
			model.addAttribute("message","User/Password Invalid");
			return "login";
		}
	}
	
	
	
	@RequestMapping("/home")
	public String redirectHome(){
		
		return "home";
	}
	
	
}
