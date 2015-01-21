package com.sow.biblio.service;

import java.util.List;

import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sow.biblio.service.model.Department;
import com.sow.biblio.service.model.Employee;
import com.sow.biblio.service.model.Employee1;

@Service("exampleService1")
public class ExampleService1 extends BiblioServiceBaseAccessor implements IExampleService1 {
	
	private static final Logger LOG = LoggerFactory.getLogger(ExampleService1.class);
	
	public List<Department> getAllDepartments() {
		
		List<Department> departmentList = null;
		
		String query= "select d from Department d";
		TypedQuery<Department> q = em.createQuery(query, Department.class);
		
		departmentList = q.getResultList();

		return departmentList;
	}
	
	@Transactional(readOnly=false)
	public void saveDepartment() {
		
		Department department = new Department();
		department.setDeptId(3);
		department.setDeptName("Computers");
		department.setDeptDesc("Computers Desc");
		
		em.merge(department);
			
	}
	
	@Transactional(readOnly=true)
	public Employee getEmployee(long empId) {
		Employee e = null;
		
		e = em.find(Employee.class, empId);
		
		if (e == null) {
			System.out.println("in getEmployee e is null");
		} else {
			
			System.out.println("in getEmployee e is Not null");
			
			if (em.contains(e)) {
				System.out.println("e is in session");
			} else {
				System.out.println("e is NOT  in session");
			}
		}
			
		return e;
	}
	
	public List<Employee> getAllEmployees() {
		
		List<Employee> employeeList = null;
		
		String query= "select e from Employee e";
		TypedQuery<Employee> q = em.createQuery(query, Employee.class);
		
		employeeList = q.getResultList();

		return employeeList;
	}
	
	@Transactional(readOnly=false)
	public void saveEmployee() {
		
		Employee employee = new Employee();
	
		//employee.setEmpId(6050l);
		employee.setFirstName("John2");
		employee.setLastName("Lee2");
		employee.setDesignation("Janitor3");
				
		em.merge(employee);
	}
	
	@Transactional(readOnly=false)
	public void saveEmployee(Employee employee) {	
		
		if (em.contains(employee)) {
			System.out.println("employee is in session");
		} else {
			System.out.println("employee is NOT  in session");
		}
		
		employee = em.merge(employee);
		
		em.flush();
		
		if (em.contains(employee)) {
			System.out.println("now employee is in session");
		} else {
			System.out.println("now employee is NOT  in session");
		}
	}
	
	@Transactional(readOnly=false)
	public void saveEmployeeWithId(long id) {
		
		Employee1 employee1 = new Employee1();
		
		employee1.setEmpId(7000l);
		employee1.setFirstName("John5");
		employee1.setLastName("Lee5");
		employee1.setDesignation("Janitor5");
				
		em.merge(employee1);
	}
}
