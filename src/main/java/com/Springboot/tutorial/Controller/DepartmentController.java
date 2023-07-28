package com.Springboot.tutorial.Controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Springboot.tutorial.Entity.Department;
import com.Springboot.tutorial.Error.DepartmentNotFoundException;
import com.Springboot.tutorial.Service.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;

	private Logger logger = LoggerFactory.getLogger(DepartmentController.class);

	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		
		logger.info("Inside saveDepartment method in "+getClass());
		return departmentService.saveDepartment(department);
	}

	@GetMapping("/departments")
	public List<Department> getAllDepartments() {
		
		logger.info("Inside getAllDepartments method in "+getClass());
		return departmentService.getAllDepartments();
	}

	@GetMapping("/departments/{id}")
	public Department getDepartment(@PathVariable("id") long departmentId) throws DepartmentNotFoundException {

		return departmentService.getDepartment(departmentId);
	}

	@PutMapping("/departments/{id}")
	public Department updateDepartment(@PathVariable("id") long departmentId, @RequestBody Department department) {

		return departmentService.updateDepartment(departmentId, department);
	}

	@DeleteMapping("/departments/{id}")
	public String deleteDepartment(@PathVariable("id") long departmentId) {

		departmentService.deleteDepartment(departmentId);
		return "Deleted Department Successfully";
	}

}
