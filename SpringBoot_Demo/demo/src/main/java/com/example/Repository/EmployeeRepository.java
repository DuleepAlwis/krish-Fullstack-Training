package com.example.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.EmployeeEntity;

@Repository	
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Integer>{

	public EmployeeEntity save(EmployeeEntity entity);
	
	public EmployeeEntity getById(int id);
	
	 public List<EmployeeEntity> findAll();
	
	 @Query(value="select e from EmployeeEntity e where name=?1", nativeQuery=false)
	 public EmployeeEntity getByName(String name);
	
}
