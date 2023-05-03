package com.tasks.in.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tasks.in.entity.Employee;
import com.tasks.in.entity.EmployeeEntity;
import com.tasks.in.entity.Tax;

@Repository
public interface EmployeeEntityRepository extends JpaRepository<EmployeeEntity, Long>{

	EmployeeEntity findById(long id);
	Employee findByEmail(String email);
	void save(Tax taxInstance);
	
}
