package com.Springboot.tutorial.Controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.Springboot.tutorial.Entity.Department;
import com.Springboot.tutorial.Error.DepartmentNotFoundException;
import com.Springboot.tutorial.Service.DepartmentService;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	private DepartmentService departmentService;
	
	private Department department;
	
	@BeforeEach
	void setUp() throws Exception {
		department= new Department(1l, "ME", "Aurangabad", "ME-01");

	}

	@Test
	void test_Save() throws Exception {
		
		Department inDepartment=new Department("ME", "Aurangabad", "ME-01");
		
		Mockito.when(departmentService.saveDepartment(inDepartment)).thenReturn(department);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/departments")
					.contentType(MediaType.APPLICATION_JSON)
					.content("{\"departmentName\":\"ME\",\""
							+ "departmentAddress\":\"Aurangabad\","
							+ "\"departmentCode\":\"ME-01\"}"))
					.andExpect(MockMvcResultMatchers.status().isOk());
					
	}
	
	@Test
	void test_getDepartment() throws Exception {
		
	
		Mockito.when(departmentService.getDepartment(1l)).thenReturn(department);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/departments/{id}",1l))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}

}



























