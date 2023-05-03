package com.tasks.in.service;

import com.tasks.in.entity.Employee;
import com.tasks.in.entity.EmployeeEntity;
import com.tasks.in.entity.Tax;

public interface EmployeeService {

	EmployeeEntity save(Employee emp);
	Tax savee(long empid);
}
