package com.sim1zzo.pma.services;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	IStaffRepository staffRepo;

	public EmployeeService(IStaffRepository staffRepo) {
		super();
		this.staffRepo = staffRepo;
	}
	
	

}
