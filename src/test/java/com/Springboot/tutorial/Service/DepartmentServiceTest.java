package com.Springboot.tutorial.Service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.Springboot.tutorial.Entity.Department;
import com.Springboot.tutorial.Error.DepartmentNotFoundException;
import com.Springboot.tutorial.Repository.DepartmentRepository;

@SpringBootTest
class DepartmentServiceTest {

	@Autowired
	private DepartmentService departmentService;

	@MockBean
	private DepartmentRepository departmentRepository;

	private Department department;
	
	private Optional<Department> departmentOptional;

	@BeforeEach
	void setUp() throws Exception {

		department = new Department(1l, "ME", "Aurangabad", "ME-01");
		departmentOptional= Optional.of(department);
	}

	@Test
	public void whenSaveDepartment_thenReturnDepartment() {

		Mockito.when(departmentRepository.save(department)).thenReturn(department);
		Department saveDepartment = departmentService.saveDepartment(department);
		assertEquals("ME", saveDepartment.getDepartmentName());
	}
	
	
	@Test
	public void whenGetDepartmentById_thenReturnDepartment() throws DepartmentNotFoundException {
		
		Mockito.when(departmentRepository.findById(1l)).thenReturn(departmentOptional);
		Department department2 = departmentService.getDepartment(1l);
		
		assertEquals("ME", department2.getDepartmentName());
	}

}
