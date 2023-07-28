package com.Springboot.tutorial.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Springboot.tutorial.Entity.Department;
import com.Springboot.tutorial.Error.DepartmentNotFoundException;
import com.Springboot.tutorial.Repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Department saveDepartment(Department department) {
		// TODO Auto-generated method stub
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		List<Department> departments = departmentRepository.findAll();
		return departments;
	}

	@Override
	public Department getDepartment(long departId) throws DepartmentNotFoundException {
		// TODO Auto-generated method stub
		 Optional<Department> departmentOptional = departmentRepository.findById(departId);
		 if (!departmentOptional.isPresent()) {
			throw new DepartmentNotFoundException("Department not found");
		}
		 
		 return departmentOptional.get();
	}

	@Override
	public Department updateDepartment(long id, Department department) {
		// TODO Auto-generated method stub
		Department departmentDB = departmentRepository.findById(id).get();

		if (Objects.nonNull(departmentDB.getDepartmentName()) && !"".equalsIgnoreCase(departmentDB.getDepartmentName())) {

			departmentDB.setDepartmentName(department.getDepartmentName());
		}
		if (Objects.nonNull(departmentDB.getDepartmentAddress()) && !"".equalsIgnoreCase(departmentDB.getDepartmentAddress())) {

			departmentDB.setDepartmentAddress(department.getDepartmentAddress());
		}
		if (Objects.nonNull(departmentDB.getDepartmentCode()) && !"".equalsIgnoreCase(departmentDB.getDepartmentCode())) {

			departmentDB.setDepartmentCode(department.getDepartmentCode());
		}
		return departmentDB;
	}

	@Override
	public void deleteDepartment(long id) {
		// TODO Auto-generated method stub
		departmentRepository.deleteById(id);
	}

}
