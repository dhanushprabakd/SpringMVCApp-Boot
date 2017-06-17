package trng.imcs.app.services;

import org.springframework.stereotype.Service;

import trng.imcs.app.model.Employee;
import trng.imcs.app.respirotories.EmployeeDBImpl;
import trng.imcs.app.respirotories.EmployeeDBInterface;

@Service
public class EmployeeOperations {
	
	EmployeeDBInterface dbImpl = new EmployeeDBImpl();
	
	public Employee getEmployee(int empNo){
		return dbImpl.getEmployeeInfo(empNo);
	}
}
