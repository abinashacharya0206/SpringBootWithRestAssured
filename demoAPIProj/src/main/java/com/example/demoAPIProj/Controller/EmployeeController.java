package com.example.demoAPIProj.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoAPIProj.Model.Employees;
import com.example.demoAPIProj.service.EmployeeService;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService eService;
	
	@GetMapping("/AllEmployees")
	public ResponseEntity<List<Employees>> getAllEmployee(@RequestHeader("User-Application") String customHeader, @RequestParam int count) {
		return eService.getAllEmployee();
		
	}
	@GetMapping("/dept/{dept}")
	public List<Employees> getEmployeesByDept(@PathVariable String dept){
		return eService.getEmployeesByDept(dept);
		
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addEmployees(@RequestBody Employees emp) {
		return	eService.addEmployee(emp);
			 
	}
	
	@PostMapping("/testadd")
	public ResponseEntity<String> addMultiEmployee(@RequestHeader("User-Application") String customHeader, @RequestParam String dept, @RequestParam int count, @RequestBody List<Employees> emp) {
		return eService.addMultiEmployee(emp);
		
	}

}
