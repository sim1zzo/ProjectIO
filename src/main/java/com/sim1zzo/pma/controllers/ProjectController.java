package com.sim1zzo.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sim1zzo.pma.dao.EmployeeRepository;
import com.sim1zzo.pma.dao.ProjectRepository;
import com.sim1zzo.pma.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	private ProjectRepository proRepo;
	
	@Autowired
	private EmployeeRepository empRepo;

	@RequestMapping("/new")
	public String displayProjectForm(Model model) {
		
		var aProject = new Project();
		
		var employees = empRepo.findAll();
		
		model.addAttribute("project", aProject);
		model.addAttribute("allEmployees", employees);
		
		return "projects/new-project";
	}
	
	
	@PostMapping("/save")
	public String createProject(Project project, @RequestParam List<Long> employees, Model model) {
		proRepo.save(project);
		
//		var chosenEmployees = empRepo.findAllById(employees);
		
//		for(var emp :chosenEmployees ) {
//			emp.setProject(project);
//			empRepo.save(emp);
//		}
		return "redirect:/projects";
//	This will handle the saving to the database;
		
	}
	
	@GetMapping
	public String displayProjects(Model model) {
		var projects = proRepo.findAll();
		model.addAttribute("projects",projects );
		
		return "projects/projects";
		
	}
}
