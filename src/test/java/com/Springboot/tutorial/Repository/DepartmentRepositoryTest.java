package com.Springboot.tutorial.Repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.Springboot.tutorial.Entity.Department;

@DataJpaTest
class DepartmentRepositoryTest {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@BeforeEach
	void setUp() throws Exception {
	 Department department = new Department();
	 department.setDepartmentAddress("Aurangabad");
	 department.setDepartmentName("ME-01");
		entityManager.persist(department);
	}
	
	@Test
	public void test() {
		
		Department findById = departmentRepository.findById(1l).get();
		assertEquals("Aurangabad", findById.getDepartmentAddress());
	}

	

}
