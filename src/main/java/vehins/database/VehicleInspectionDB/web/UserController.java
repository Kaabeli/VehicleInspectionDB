package vehins.database.VehicleInspectionDB.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vehins.database.VehicleInspectionDB.domain.SignupForm;
import vehins.database.VehicleInspectionDB.domain.User;
import vehins.database.VehicleInspectionDB.domain.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository urepository;
	
	@RequestMapping(value = "signup")
	public String addUser(Model model) {
		model.addAttribute("signupform", new SignupForm());
		return "signup";
	}
	
	@RequestMapping(value = "saveuser", method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("signupform") SignupForm signupform, BindingResult bindingResult) {
    	if (!bindingResult.hasErrors()) { 
    		if (signupform.getPassword().equals(signupform.getPasswordCheck())) { 	
	    		String pwd = signupform.getPassword();
		    	BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
		    	String hashPwd = bc.encode(pwd);
	
		    	User newUser = new User();
		    	newUser.setPasswordHash(hashPwd);
		    	newUser.setUsername(signupform.getUsername());
		    	newUser.setRole("USER");
				if (urepository.findByUsername(signupform.getUsername()) == null) {
					urepository.save(newUser);
		    	}
		    	else {
	    			bindingResult.rejectValue("username", "err.username", "Username already exists");    	
	    			return "signup";		    		
		    	}
    		}
    		else {
    			bindingResult.rejectValue("passwordCheck", "err.passCheck", "Passwords does not match");    	
    			return "signup";
    		}
    	}
    	else {
    		return "signup";
    	}
    	return "redirect:/login";    	
    }    
    
		
	}
