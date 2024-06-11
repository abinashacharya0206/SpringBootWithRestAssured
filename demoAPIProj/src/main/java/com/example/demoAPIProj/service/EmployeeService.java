package com.example.demoAPIProj.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demoAPIProj.DAO.EmployeesDAO;
import com.example.demoAPIProj.Model.Employees;

@Service
public class EmployeeService {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);
	
	@Autowired
	EmployeesDAO eDAO;

	public ResponseEntity<List<Employees>> getAllEmployee() {
		try {
		return new ResponseEntity(eDAO.findAll(), HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
		
		
	}

	public List<Employees> getEmployeesByDept(String department) {
		// TODO Auto-generated method stub
		return eDAO.findByDepartment(department);
	}

	public ResponseEntity<String> addEmployee(Employees emp) {
		eDAO.save(emp);
		return new ResponseEntity<>("Success", HttpStatus.CREATED);
		
		
	}

	public ResponseEntity<String> addMultiEmployee(List<Employees> emp) {
		eDAO.saveAll(emp);
		return new ResponseEntity<>("Success", HttpStatus.CREATED);
		
	}


}
