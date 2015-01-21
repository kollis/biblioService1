package com.sow.biblio.service;

import java.util.List;

import com.sow.biblio.service.model.Department;
import com.sow.biblio.service.model.Employee;

public interface IExampleService1 {
	
	public List<Department> getAllDepartments();
	public void saveDepartment();
	
	public List<Employee> getAllEmployees();
	public Employee getEmployee(long empId);
	public void saveEmployee();
	public void saveEmployee(Employee e);
	public void saveEmployeeWithId(long id);
}
