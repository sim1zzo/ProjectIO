package com.sim1zzo.pma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sim1zzo.pma.dao.EmployeeRepository;
import com.sim1zzo.pma.entities.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository empRepo;
	
	
	@RequestMapping("/new")
	public String displayEmployeeForm(Model model) {
		
		var anEmployee = new Employee();
		
		model.addAttribute("employee", anEmployee);
		
		return "employees/new-employee";
	}
	
	
	@PostMapping("/save")
	public String createEmployee(Employee employee, Model model) {
		
		empRepo.save(employee);
		return "redirect:/employees/new";
	}
	
	@GetMapping
	public String displayEmployees(Model model) {
		
		var employees = empRepo.findAll();
		model.addAttribute("employees", employees);
		
		return "employees/employees";
	}

}
