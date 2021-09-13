package com.sim1zzo.pma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//import java.util.HashMap;
//import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sim1zzo.pma.dao.EmployeeRepository;
import com.sim1zzo.pma.dao.ProjectRepository;
import com.sim1zzo.pma.springExample.Car;

@Controller
public class HomeController {


	@Autowired
	Car car;

	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	
	@GetMapping("/")
	public String displayHome(Model model) throws JsonProcessingException {
		
//		Map<String, Object> map = new HashMap<>();
		
		var projects = proRepo.findAll();
		model.addAttribute("projects", projects);
		
		var projectData = proRepo.getProjectStatus();
		
//		convert projectData into a JSON structure for JS usage;
		var  objMapper = new ObjectMapper();
		
		var jsonString = objMapper.writeValueAsString(projectData);
//		jsonString will like 
//		[ ["NOTSTARTED", 1],["INPROGRESS", 2],["COMPLETED", 3]	]
		model.addAttribute("projectStatusCount", jsonString);
		
		
		var employeesProjectCount = empRepo.employeeProjects();
		model.addAttribute("employeesProjectCounts", employeesProjectCount);
		return "main/home";
	}
}
