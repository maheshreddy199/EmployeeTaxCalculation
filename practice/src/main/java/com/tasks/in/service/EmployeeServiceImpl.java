package com.tasks.in.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tasks.in.entity.Employee;
import com.tasks.in.entity.EmployeeEntity;
import com.tasks.in.entity.Tax;
import com.tasks.in.repository.EmployeeEntityRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeEntityRepository repo;

	@Override
	public EmployeeEntity save(Employee emp) {

		EmployeeEntity employee = new EmployeeEntity(0L, emp.getFirstName(), emp.getLastName(), emp.getEmail(),
				emp.getPhoneNumber(), emp.getDateOfJoining(), emp.getSalary());

		return repo.save(employee);
	}

	@Override
	public Tax savee(long id) {
		EmployeeEntity emp = repo.findById(id);
		LocalDate joiningDate = LocalDate.parse(emp.getDateOfJoining());
		LocalDate yearStartingDate = LocalDate.of(2022, 03, 31);
		LocalDate yearLastDate = LocalDate.of(2023, 03, 31);
		long totalSalary = 0;
		int tax = 0;
		int cess = 0;
		if (joiningDate.compareTo(yearStartingDate) < 0) {
			totalSalary = emp.getSalary() * 12;
			if (totalSalary > 2500000) {
				int extraAmount = (int) (totalSalary - 2500000);
				cess = (extraAmount * 2) / 100;
			}
			tax = caculateTax(totalSalary);
		} else {
			int extractMonth = joiningDate.getMonthValue();
			int extractDay = joiningDate.getDayOfMonth();
			if (extractDay < 15) {
				int noOfMonths = 12 - extractMonth + 4;
				totalSalary = emp.getSalary() * noOfMonths;
				if (totalSalary > 2500000) {
					int extraAmount = (int) (totalSalary - 2500000);
					cess = (extraAmount * 2) / 100;
				}
				tax = caculateTax(totalSalary);
			} else {
				int noOfMonths = 12 - extractMonth + 3;
				long fewDaysSalary = (30 - extractDay) * (emp.getSalary() / 30);
				totalSalary = noOfMonths * emp.getSalary() + fewDaysSalary;
				if (totalSalary > 2500000) {
					int extraAmount = (int) (totalSalary - 2500000);
					cess = (extraAmount * 2) / 100;
				}
				tax = caculateTax(totalSalary);
			}
		}

		long empid = emp.getId();
		String firstName = emp.getFirstName();
		String lastName = emp.getLastName();
		long yearlySalary = totalSalary;
		long taxAmount = tax;
		long cessAmount = cess;
		Tax taxInstance = new Tax(1L, empid, firstName, lastName, yearlySalary, taxAmount, cessAmount);
		repo.save(taxInstance);
		return taxInstance;
	}

	public int caculateTax(long totalSalary) {
		long yearlySalary = totalSalary;
		int basicTax = 0;
		if (yearlySalary < 250000) {
			basicTax = 0;
			return basicTax;
		} else if (yearlySalary <= 500000) {
			long restSalary = yearlySalary - 250000;
			int tax = (int) ((restSalary * 5) / 100);
			basicTax = tax;
			return basicTax;
		} else if (yearlySalary <= 1000000) {
			long restSalary = yearlySalary - 500000;
			int tax = (int) ((restSalary * 10) / 100);
			basicTax = 12500 + tax;
			return basicTax;
		} else if (yearlySalary > 2500000) {
			int restSalary = (int) (yearlySalary - 1000000);
			int tax = (restSalary * 20) / 100;
			basicTax = tax + 12500 + 50000;
			return basicTax;
		}
		return basicTax;
	}

}
