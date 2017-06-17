package trng.imcs.app.respirotories;

import trng.imcs.app.model.Employee;

public class EmployeeDBImpl implements EmployeeDBInterface {
	DBQueryExecution querryExecution = new DBQueryExecution();
	@Override
	public Employee getEmployeeInfo(int empNo) {
		return querryExecution.getEmployeeRecords(empNo);
	}

}
