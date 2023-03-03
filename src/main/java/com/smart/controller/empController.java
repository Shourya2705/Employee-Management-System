package com.smart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.smart.entity.Employee;
import com.smart.service.empService;

import jakarta.servlet.http.HttpSession;

@Controller
public class empController {
	
	@Autowired
	private empService service;

	@GetMapping("/")
	public String home(Model m) {
		List<Employee> emp=service.getAllEmp();
		m.addAttribute("emp",emp);
		return "index";
	}
	
	@GetMapping("/addemp")
	public String addEmp() {
		return "add_emp";
	}
	
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e,HttpSession session) {
		System.out.println(e);
		
		service.addEmp(e);
		session.setAttribute("msg","Employee added sucessfully.....");
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id,Model m) {
		Employee e=service.getEmpById(id);
		m.addAttribute("emp",e);
		return "edit";
	}
	
	@PostMapping("/update")
	public String empUpdate(@ModelAttribute Employee e) {
		service.addEmp(e);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String empdelete(@PathVariable int id) {
		service.deleteEmp(id);
		return "redirect:/";
	}
}
