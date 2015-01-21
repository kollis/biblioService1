package com.sow.biblio.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sow.biblio.service.model.Department2;
import com.sow.biblio.service.model.Employee1;
import com.sow.biblio.service.model.Employee2;

@Service("exampleService2")
public class ExampleService2 extends BiblioServiceBaseAccessor implements IExampleService2 {
	
	private static final Logger LOG = LoggerFactory.getLogger(ExampleService2.class);
		
	@Transactional(readOnly=true)
	public Employee2 getEmployee(long empId) {
		Employee2 e = null;
		
		e = em.find(Employee2.class, empId);
			
		return e;
	}
	
	public List<Employee2> getAllEmployees() {
		
		List<Employee2> employeeList = null;
		
		String query= "select e from Employee2 e";
		TypedQuery<Employee2> q = em.createQuery(query, Employee2.class);
		
		employeeList = q.getResultList();

		return employeeList;
	}
	
	@Transactional (readOnly=true)
	public List<Department2> getAllDepartments() {
		
		List<Department2> departmentList = null;
		
		String query= "select d from Department2 d";
		TypedQuery<Department2> q = em.createQuery(query, Department2.class);
		
		departmentList = q.getResultList();
		
		System.out.println("got the departmentList");
		
		for (Department2 d : departmentList) {
			System.out.println("\n\n\n--------Dept Id, Dept Name:" + d.getDeptId() + ", " + d.getDeptName());
			Set<Employee2> employeeSet = d.getEmployees();
			
			for (Employee2 e : employeeSet) {
				System.out.println("EmpId, EmpName:" + e.getEmpId() + ", " + e.getFirstName());
			}
		}
		
		System.out.println("\n\n\n\nEnd getAllDepartments");
		
		return departmentList;
		
	}
	
	@Transactional (readOnly=false)
	public void createAndSaveMultipleEmployeesWithNullDepartment(){
		
		System.out.println("\n Begin method createAndSaveMultipleEmployeesWithNullDepartment");
		
		for (int i=0; i<22; i++) {
			Employee2 e = new Employee2();
			
			e.setFirstName("Ann"+i);
			e.setLastName("Murray"+i);
			e.setDesignation("BookKeeper"+i);
			e.setDepartment(null);
			
			em.persist(e);
			
//			if (i % 4 == 0) {
//				em.flush();
//			}
			
			System.out.println("\n Saved Employee" + i);
		}
				
		System.out.println("\n End method createAndSaveMultipleEmployeesWithNullDepartment");
	}
	
	@Transactional (readOnly=false)
	public void createAndSaveMultipleEmployeesWithAssignedKey() {
		
		System.out.println("\n Begin method createAndSaveMultipleEmployeesWithAssignedKey");
		
		for (long i=1000; i<1022; i++) {
			Employee1 e = new Employee1();
			
			e.setEmpId(i);
			e.setFirstName("Ann"+i);
			e.setLastName("Murray"+i);
			e.setDesignation("BookKeeper"+i);
			
			em.persist(e);
	
			System.out.println("\n Saved Employee" + i);
		}
				
		System.out.println("\n End method createAndSaveMultipleEmployeesWithAssignedKey");
		
	}
	
	@Transactional (readOnly=false)
	public void saveNewEmployeeWithExistingDeptId() {
		
		System.out.println("\n Begin method saveNewEmployeeWithExistingDeptId");
		
		Employee2 e = new Employee2();

		e.setFirstName("Ann1");
		e.setLastName("Murray1");
		e.setDesignation("BookKeeper1");
		Department2 d = new Department2();
		d.setDeptId(1);
		e.setDepartment(d);
		
		em.persist(e);
		
		System.out.println("\n End method saveNewEmployeeWithExistingDeptId");
	}
	
	@Transactional (readOnly=false)
	public void saveNewEmployeeWithExistingDept() {
		
		System.out.println("\n Begin method saveNewEmployeeWithExistingDept");
		
		Employee2 e = new Employee2();

		e.setFirstName("Ann1");
		e.setLastName("Murray1");
		e.setDesignation("BookKeeper1");
		Department2 d = em.find(Department2.class, 2l);
		d.setDeptDesc("test");
		e.setDepartment(d);
		
		em.persist(e);
		
		
		System.out.println("\n End method saveNewEmployeeWithExistingDept");
		
	}
	
	@Transactional (readOnly=false)
	public void saveNewEmployeeWithNewDept() {
		
		System.out.println("\n Begin method saveNewEmployeeWithNewDept");
		
		Employee2 e = new Employee2();

		e.setFirstName("Ann1");
		e.setLastName("Murray1");
		e.setDesignation("BookKeeper1");
		Department2 d = new Department2();
		d.setDeptName("Pharmacy");
		d.setDeptDesc("Pharmacy Dept");
		e.setDepartment(d);
		
		em.persist(e);
		
		
		System.out.println("\n End method saveNewEmployeeWithNewDept");
		
	}
	
	@Transactional (readOnly=false)
	public void saveNewDepartmentWithExistingEmployee() {
		
		System.out.println("\n Begin method saveNewDepartmentWithExistingEmployee");
		
		Department2 d = new Department2();
		d.setDeptName("Pharmacy1");
		d.setDeptDesc("Pharmacy Dept1");
		
		Employee2 e = em.find(Employee2.class, 100l);
		Set<Employee2> employeeSet = new HashSet<Employee2>();
		employeeSet.add(e);
		
		d.setEmployees(employeeSet);
		
		em.persist(d);
		
		System.out.println("\n End method saveNewDepartmentWithExistingEmployee");
	}
}
