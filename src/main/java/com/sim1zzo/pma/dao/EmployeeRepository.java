package com.sim1zzo.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sim1zzo.pma.dto.EmployeeProject;
import com.sim1zzo.pma.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	
	@Override
	public List<Employee> findAll();
	
	@Query(nativeQuery=true, value="SELECT e.first_name as firstName, e.last_name as lastName, COUNT(pe.EMPLOYEE_ID) as projectCount "
			+ "FROM EMPLOYEE e LEFT JOIN PROJECT_EMPLOYEE pe ON pe.PROJECT_ID = e.EMPLOYEE_ID "
			+ "GROUP BY e.FIRST_NAME , e.LAST_NAME ORDER BY 3 DESC;")
	public List<EmployeeProject> employeeProjects();
	
	

}
