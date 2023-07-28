package com.Springboot.tutorial.Service;

import java.util.List;

import com.Springboot.tutorial.Entity.Department;
import com.Springboot.tutorial.Error.DepartmentNotFoundException;

public interface DepartmentService {

	Department saveDepartment(Department department);

	List<Department> getAllDepartments();

	Department getDepartment(long departId) throws DepartmentNotFoundException;

	Department updateDepartment(long id, Department department);

	void deleteDepartment(long id);

}
