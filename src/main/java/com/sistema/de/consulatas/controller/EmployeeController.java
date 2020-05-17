package com.sistema.de.consulatas.controller;

import com.sistema.de.consulatas.model.Employee;
import com.sistema.de.consulatas.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
	
    @RequestMapping(value="/default", method = RequestMethod.GET)
    public String defaultAccess(HttpServletRequest request){
    	
        if(request.isUserInRole("ROLE_ADMIN")) {
        	return "redirect:/employee";
        }
        else if(request.isUserInRole("ROLE_USER")) {
        	
        	return "redirect:/SantoDomingo";
    		
        }
        
        return "";
    }

    
	@GetMapping("/employee")
	public ModelAndView getEmployee() {
		ModelAndView view =  new ModelAndView("employee");
		view.addObject("employee", new Employee());
		view.addObject("employees", employeeService.getAllEmployee());
		return view;
		
	}
	
	@GetMapping("/employee/delete/{userId}")
	public String deleteEmployee(@PathVariable Long userId) {
		employeeService.deleteEmployee(userId);
		return "redirect:/employee";
		
	}
	
	@GetMapping("/employee/edit/{userId}")
	public String editEmployee(Model model,@PathVariable Long userId) {
		
		model.addAttribute("employee", employeeService.getEmployee(userId));
		model.addAttribute("employees", employeeService.getAllEmployee());
		
		return "employee";
		
	}
	
	
	@PostMapping("/employee/save")
	public String saveEmployee(@ModelAttribute("employee") Employee e) {
		employeeService.saveEmployeeService(e);
		return "redirect:/employee";
	}
}
