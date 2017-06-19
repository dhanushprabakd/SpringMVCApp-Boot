package trng.imcs.app.respirotories;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import trng.imcs.app.model.Department;
import trng.imcs.app.model.Employee;

public class EmployeeDBImpl implements EmployeeDBInterface {
	EmployeeDao employeeDao = new EmployeeDao();
	DepartmentNameDao departmentDao = new DepartmentNameDao();
	EmployeeSalaryDao employeeSalaryDao = new EmployeeSalaryDao();

	@Override
	public Employee getEmployeeInfo(int empNo) {
		return employeeDao.getEmployeeRecords(empNo);
	}

	@Override
	public Department getDepartmentName(int empNo) {
		Department dept = new Department();
		dept.setDeptNo(departmentDao.getDepartmentNumber(empNo));
		dept.setDeptName(departmentDao.getDepartmentName(dept.getDeptNo()));
		return dept;
	}

	@Override
	public double getSalary(int empNo) {

		return employeeSalaryDao.getSalary(empNo);
	}

	@Override
	public boolean addnewEmployee(Employee emp, Double salary, String deptName) {
		setAutoCommit(false);
		boolean addFlag = employeeDao.AddEmployeeRecord(emp);
		boolean deptFlag = departmentDao.addEmployeeDept(deptName, emp.getNumber(), new Date(emp.getHireDate().getTime()));
		boolean salFlag = employeeSalaryDao.addEmployeeSalary(salary, emp.getNumber(), new Date(emp.getHireDate().getTime()));
		if (addFlag && deptFlag && salFlag) {
			System.out.println("Employee Added");
			setCommit(true);
			setAutoCommit(true);
			return true;
		} else {
			System.out.println("Error");
			setCommit(false);
			setAutoCommit(true);
			return false;
		}
	}

	@Override
	public void setAutoCommit(boolean b) {
		System.out.println("in autocommit" + b);
		Connection conn = JDBCConnectionFactory.getConnection();
		try {
			conn.setAutoCommit(b);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void setCommit(boolean flag) {
		Connection conn = JDBCConnectionFactory.getConnection();
		if(flag)
			try {
				conn.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else
			try {
				conn.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

	@Override
	public boolean updateEmployee(Employee emp, double salary, String deptName) {
		
		setAutoCommit(false);
		boolean empFlag = employeeDao.updateEmployeeRecord(emp);
		boolean deptFlag = departmentDao.updateEmplpyeeDept(deptName, emp.getNumber(), new Date(emp.getHireDate().getTime()));
		boolean salFlag = employeeSalaryDao.updateEmployeeSalary(salary, emp.getNumber(), new Date(emp.getHireDate().getTime()));
		if (empFlag) {
			System.out.println("Employee Added");
			setCommit(true);
			setAutoCommit(true);
			return true;
		} else {
			System.out.println("Error");
			setCommit(false);
			setAutoCommit(true);
			return false;
		}
	}



}
