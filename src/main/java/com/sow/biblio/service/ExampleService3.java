package com.sow.biblio.service;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sow.biblio.service.model.Department3;
import com.sow.biblio.service.model.Employee3;

@Service("exampleService3")
public class ExampleService3 extends BiblioServiceBaseAccessor implements IExampleService3 {
	
	private static final Logger LOG = LoggerFactory.getLogger(ExampleService3.class);
		
	@Transactional (readOnly=false)
	public void saveNewDepartmentWithExistingEmployee() {
		
		System.out.println("\n Begin method saveNewDepartmentWithExistingEmployee");
		
		Department3 d = new Department3();
		d.setDeptName("Pharmacy1");
		d.setDeptDesc("Pharmacy Dept1");
		
		Employee3 e = em.find(Employee3.class, 100l);
		Set<Employee3> employeeSet = new HashSet<Employee3>();
		employeeSet.add(e);
		
		d.setEmployees(employeeSet);
		
		em.persist(d);
		
		System.out.println("\n End method saveNewDepartmentWithExistingEmployee");
	}
}
