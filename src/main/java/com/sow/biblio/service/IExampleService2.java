package com.sow.biblio.service;

import java.util.List;

import com.sow.biblio.service.model.Department2;
import com.sow.biblio.service.model.Employee2;

public interface IExampleService2 {
	
	public List<Employee2> getAllEmployees();
	public Employee2 getEmployee(long empId);
	public void createAndSaveMultipleEmployeesWithNullDepartment();
	public void createAndSaveMultipleEmployeesWithAssignedKey();
	
	public void saveNewEmployeeWithExistingDeptId();
	
	public void saveNewEmployeeWithExistingDept();
	
	public void saveNewEmployeeWithNewDept();
	
	public List<Department2> getAllDepartments();	
	
	public void saveNewDepartmentWithExistingEmployee();
}
