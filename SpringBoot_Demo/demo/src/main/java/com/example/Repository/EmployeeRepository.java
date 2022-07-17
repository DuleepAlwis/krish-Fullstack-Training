package com.example.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.EmployeeEntity;

@Repository	
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Integer>{

	public EmployeeEntity save(EmployeeEntity entity);
	
	
	
	
}
