package com.example.demoAPIProj.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.example.demoAPIProj.Model.Employees;

@Repository
public interface EmployeesDAO extends JpaRepository<Employees, Integer> {
	
	List<Employees> findByDepartment(String Department);
	
}
