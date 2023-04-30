package com.gcu;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/aloehealth")
public class ControllerForPages {

		
	@GetMapping("/home") 
	public String showHomePage( Model model) { 
		return "home";
		
	}
	
	@GetMapping("/appointments") 
	public String showAppointmentsPage( Model model) { 
		 return "appointments";
		
	}
	
	@GetMapping("/services") 
	public String showMedicalServicesPage( Model model) { 
		 return "services";
		
	}
	
	@GetMapping("/financialcalculator") 
	public String showFinancialCalculatorPage( Model model) { 
		 return "calculator";
		
	}
	
	@GetMapping("/medicalstaff") 
	public String showMedicalStaffPage( Model model) { 
		 return "staff";
		
	}
	
	@GetMapping("/contacts") 
	public String showContactsPage( Model model) { 
		 return "contacts";
		
	}
	
	@GetMapping("/about") 
	public String showAboutPage( Model model) { 
		 return "about";
		
	}
	
	@GetMapping("/feedback") 
	public String showFeedbackPage( Model model) { 
		 return "feedback";
		
	}
	
	@GetMapping("/help") 
	public String showHelpPage( Model model) { 
		 return "help";
		
	}
	
	@GetMapping("/careers") 
	public String showCareersPage( Model model) { 
		 return "careers";
		
	}
	
	@GetMapping("/terms") 
	public String showTermsPage( Model model) { 
		 return "termsandprivacy";
		
	}

}
