package com.Springboot.tutorial.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Springboot.tutorial.Entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
