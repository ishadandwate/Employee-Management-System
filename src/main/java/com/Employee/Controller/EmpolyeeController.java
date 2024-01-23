package com.Employee.Controller;

import java.util.List;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Employee.Entity.Employee;
import com.Employee.Service.EmpService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmpolyeeController {

	@Autowired
	private EmpService empService;
	
	@GetMapping("/home")
	public String home(Model m)
	{
		List<Employee> e=empService.getallemployee();
		m.addAttribute("e",e);
		return "Index";
	}
	
	@GetMapping("/addemp")
	public String addemp()
	{
		return "addemp";
	}
	
	@PostMapping("/register")
	public String registeremp(@ModelAttribute Employee e ,HttpSession session)
	{

		empService.addemp(e);
		session.setAttribute("msg", "Employee Added Successfully");
		System.out.println(e);
	
		return "redirect:/home";
	}
	
	@GetMapping("/edit/{id}")
	public String getempbyid(@PathVariable long id,Model m)
	{
		
		Employee e= empService.getid(id);
		m.addAttribute("e",e);
		return "edit";
		
		
	}
	
	@PostMapping("/update")
	public String updatemp(@ModelAttribute Employee e ,HttpSession session)
	{
		
		empService.addemp(e);
		session.setAttribute("msg", "Emplyee Data Updated Successfully");
		return "redirect:/home";
		
		
	}
	
	 @GetMapping("/delete/{id}")
	 public String deleteemp(@PathVariable long id ,HttpSession session)
		{
		 	empService.deletebyid(id);
			session.setAttribute("msg", "Emplyee deleted Successfully");
			return "redirect:/home";
			
			
		}
}
